package de.urr4.mealplanner.recipe.rest;

import de.urr4.mealplanner.recipe.RecipeEntity;
import de.urr4.mealplanner.recipe.RecipeService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RecipeDTO> getAllRecipes() {
        return recipeService.getAllRecipes()
                .stream()
                .map(RecipeDTO::from)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{recipeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RecipeDTO getRecipeById(@PathVariable("recipeId") Long recipeId) {
        return RecipeDTO.from(recipeService.getRecipeById(recipeId));
    }

    @Transactional
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RecipeDTO createRecipe(@RequestBody CreateRecipeRequest createRecipeRequest) {
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setName(createRecipeRequest.getName());
        return RecipeDTO.from(recipeService.saveRecipe(recipeEntity));
    }

    @Transactional
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RecipeDTO updateRecipe(@RequestBody UpdateRecipeRequest updateRecipeRequest) {
        RecipeEntity recipeEntity = recipeService.getRecipeById(updateRecipeRequest.getId());
        recipeEntity.setName(updateRecipeRequest.getName());
        return RecipeDTO.from(recipeService.saveRecipe(recipeEntity));
    }

    @Transactional
    @DeleteMapping(path = "/{recipeId}")
    public void deleteRecipe(@PathVariable("recipeId") Long recipeId) {
        RecipeEntity recipeEntity = recipeService.getRecipeById(recipeId);
        recipeService.deleteRecipe(recipeEntity);
    }
}
