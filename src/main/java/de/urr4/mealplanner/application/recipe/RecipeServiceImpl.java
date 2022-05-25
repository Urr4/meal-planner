package de.urr4.mealplanner.application.recipe;

import de.urr4.mealplanner.domain.recipe.Recipe;
import de.urr4.mealplanner.domain.recipe.RecipeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Page<Recipe> getRecipesByPage(Pageable pageable) {
        return recipeRepository.getRecipesByPage(pageable);
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.createRecipe(recipe);
    }

    @Override
    public Recipe getRecipeById(UUID id) {
        return recipeRepository.getRecipeById(id);
    }
}
