package de.urr4.mealplanner.domain.ingredient;

import org.springframework.data.domain.Page;

import java.util.UUID;

public interface IngredientRepository {

    Page<Ingredient> loadIngredientsPage(int pageNumber, int pageSize);

    Ingredient saveIngredient(Ingredient ingredient);

    Ingredient getIngredientById(UUID ingredientId);
}
