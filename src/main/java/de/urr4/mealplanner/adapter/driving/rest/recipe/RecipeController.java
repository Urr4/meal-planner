package de.urr4.mealplanner.adapter.driving.rest.recipe;

import de.urr4.mealplanner.domain.recipe.Recipe;
import de.urr4.mealplanner.domain.recipe.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Recipe Endpoints", description = "Operations for dealing with recipes")
@RestController
@RequestMapping(path = "/recipes")
public class RecipeController {

    private final Logger LOG = LoggerFactory.getLogger(RecipeController.class);

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Operation(summary = "Get recipes pageable", description = "Fetches a page of recipes")
    @GetMapping
    public Page<RecipeDto> getRecipesByPage(@RequestParam(value = "page", defaultValue = "0") int pageNumber, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        LOG.info("Getting recipes for page {} with pageSize {}", pageNumber, pageSize);
        return recipeService.getRecipesByPage(PageRequest.of(pageNumber, pageSize)).map(RecipeMapper::toDto);
    }

    @GetMapping(path = "/{recipeId}")
    public RecipeDto getRecipe(@PathVariable("recipeId") UUID recipeId) {
        LOG.info("Getting recipe with recipeId {}", recipeId);
        return RecipeMapper.toDto(recipeService.getRecipeById(recipeId));
    }

    @PutMapping
    public RecipeDto updateRecipe(@RequestBody UpdateRecipeRequest updateRecipeRequest) {
        LOG.info("Updating recipe with recipeId {}", updateRecipeRequest.getRecipeId());
        return null; //TODO implement
    }

    @PostMapping
    public RecipeDto createRecipe(@RequestBody CreateRecipeRequest createRecipeRequest) {
        LOG.info("Creating recipe");
        return RecipeMapper.toDto(recipeService.createRecipe(mapToRecipe(createRecipeRequest)));
    }

    @DeleteMapping(path = "/{recipeId}")
    public void deleteRecipe(@PathVariable("recipeId") UUID recipeId) {
        LOG.info("Deleting recipe with recipeId {}", recipeId);
        //TODO implement
    }

    private Recipe mapToRecipe(CreateRecipeRequest createRecipeRequest) {
        Recipe recipe = new Recipe();
        recipe.setName(createRecipeRequest.getName());
        recipe.setInstructions(createRecipeRequest.getInstructions());
        return recipe;
    }
}
