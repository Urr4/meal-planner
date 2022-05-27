package de.urr4.mealplanner.application.recipe;

import de.urr4.mealplanner.domain.recipe.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface RecipeRepository {

    Page<Recipe> getRecipesByPage(Pageable pageable);

    Recipe createRecipe(Recipe recipe);

    Recipe getRecipeById(UUID id);
}