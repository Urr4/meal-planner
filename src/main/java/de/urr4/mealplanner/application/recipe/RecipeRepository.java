package de.urr4.mealplanner.application.recipe;

import de.urr4.mealplanner.domain.recipe.Recipe;
import de.urr4.mealplanner.domain.recipe.RecipeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.UUID;

public interface RecipeRepository {

    Page<Recipe> getRecipesByPage(Pageable pageable);

    Collection<Recipe> getRandomRecipes(int amount, RecipeType recipeType);

    Recipe createRecipe(Recipe recipe);

    Recipe getRecipeById(UUID id);

    Collection<Recipe> getRecipesById(Collection<UUID> ids);
}
