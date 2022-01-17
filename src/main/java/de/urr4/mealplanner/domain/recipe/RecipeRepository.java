package de.urr4.mealplanner.domain.recipe;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RecipeRepository {

    Page<Recipe> getRecipesByPage(Pageable pageable);
}
