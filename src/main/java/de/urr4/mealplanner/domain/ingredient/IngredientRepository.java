package de.urr4.mealplanner.domain.ingredient;

import org.springframework.data.domain.Page;

public interface IngredientRepository {

    Page<Ingredient> loadIngredientsPage(int pageNumber, int pageSize);

    Ingredient saveIngredient(Ingredient ingredient);
}
