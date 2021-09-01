package de.urr4.mealplanner.recipe.rest;

import de.urr4.mealplanner.descriptor.IngredientDescriptorEntity;
import de.urr4.mealplanner.descriptor.IngredientDescriptorService;
import de.urr4.mealplanner.descriptor.rest.CreateIngredientDescriptorRequest;
import de.urr4.mealplanner.descriptor.rest.IngredientDescriptorRequest;
import de.urr4.mealplanner.descriptor.rest.UpdateIngredientDescritorRequest;
import de.urr4.mealplanner.ingredients.IngredientEntity;
import de.urr4.mealplanner.ingredients.IngredientService;
import de.urr4.mealplanner.recipe.RecipeEntity;
import de.urr4.mealplanner.recipe.RecipeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RestController
@CrossOrigin
@RequestMapping(path = "/recipes")
public class RecipeController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final IngredientDescriptorService ingredientDescriptorService;

    public RecipeController(RecipeService recipeService, IngredientService ingredientService, IngredientDescriptorService ingredientDescriptorService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.ingredientDescriptorService = ingredientDescriptorService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RecipePreviewDTO> getAllRecipes() {
        log.info("Loading all Recipes");
        return recipeService.getAllRecipes()
                .stream()
                .map(RecipePreviewDTO::from)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{recipeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RecipeDetailsDTO getRecipeDetailsById(@PathVariable("recipeId") Long recipeId) {
        log.info("Loading Recipe by id " + recipeId);
        return RecipeDetailsDTO.from(recipeService.getRecipeById(recipeId));
    }

    @Transactional
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RecipeDetailsDTO createRecipe(@RequestBody @Valid CreateRecipeRequest createRecipeRequest) {
        log.info("Creating Recipe " + createRecipeRequest);
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setName(createRecipeRequest.getName());
        recipeEntity.setDescription(createRecipeRequest.getDescription());
        createRecipeRequest.getCreateIngredientDescriptorRequest().forEach(
                desc -> {
                    IngredientEntity ingredientEntity = ingredientService.getIngredientById(desc.getIngredient().getId());
                    IngredientDescriptorEntity ingredientDescriptorEntity = new IngredientDescriptorEntity();
                    ingredientDescriptorEntity.setIngredientEntity(ingredientEntity);
                    ingredientDescriptorEntity.setUnit(desc.getUnit());
                    ingredientDescriptorEntity.setAmount(desc.getAmount());
                    recipeEntity.getIngredientDescriptorEntities().add(ingredientDescriptorEntity);
                }
        );
        return RecipeDetailsDTO.from(recipeService.saveRecipe(recipeEntity));
    }

    @Transactional
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RecipeDetailsDTO updateRecipe(@RequestBody @Valid UpdateRecipeRequest updateRecipeRequest) {
        log.info("Updating Recipe " + updateRecipeRequest);
        RecipeEntity recipeEntity = recipeService.getRecipeById(updateRecipeRequest.getId());
        recipeEntity.setName(updateRecipeRequest.getName());
        recipeEntity.setDescription(updateRecipeRequest.getDescription());
        List<IngredientDescriptorEntity> ingredientDescriptorEntities = new ArrayList<>();
        for (IngredientDescriptorRequest ingredientDescriptorRequest : updateRecipeRequest.getIngredientDescriptors()) {
            IngredientDescriptorEntity ingredientDescriptorEntity;
            if (ingredientDescriptorRequest instanceof CreateIngredientDescriptorRequest) {
                ingredientDescriptorEntity = new IngredientDescriptorEntity();
            } else {
                UpdateIngredientDescritorRequest updateIngredientDescritorRequest = (UpdateIngredientDescritorRequest) ingredientDescriptorRequest;
                ingredientDescriptorEntity = ingredientDescriptorService.getIngredientDescriptorEntityById(updateIngredientDescritorRequest.getId());
            }
            ingredientDescriptorEntity.setAmount(ingredientDescriptorRequest.getAmount());
            ingredientDescriptorEntity.setUnit(ingredientDescriptorRequest.getUnit());
            IngredientEntity ingredientEntity = ingredientService.getIngredientById(ingredientDescriptorRequest.getIngredient().getId());
            ingredientDescriptorEntity.setIngredientEntity(ingredientEntity);
            ingredientDescriptorEntities.add(ingredientDescriptorEntity);
        }
        recipeEntity.getIngredientDescriptorEntities().clear();
        recipeEntity.getIngredientDescriptorEntities().addAll(ingredientDescriptorEntities);
        return RecipeDetailsDTO.from(recipeService.saveRecipe(recipeEntity));
    }

    @Transactional
    @DeleteMapping(path = "/{recipeId}")
    public void deleteRecipe(@PathVariable("recipeId") Long recipeId) {
        RecipeEntity recipeEntity = recipeService.getRecipeById(recipeId);
        recipeService.deleteRecipe(recipeEntity);
    }
}
