package de.urr4.mealplanner.domain.recipe;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.UUID;

public interface RecipeService {

    Page<Recipe> getRecipesByPage(Pageable pageable);

    Recipe createRecipe(Recipe recipe);

    Recipe getRecipeById(UUID id);

    Collection<Recipe> getRecipesByIds(Collection<UUID> ids);
}
