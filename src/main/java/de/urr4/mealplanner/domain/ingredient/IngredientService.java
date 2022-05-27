package de.urr4.mealplanner.domain.ingredient;

import org.springframework.data.domain.Page;

import java.util.UUID;

public interface IngredientService {

    Page<Ingredient> getIngredientsPage(int pageNumber, int pageSize);

    Ingredient getIngredientById(UUID ingredientId);

    Ingredient saveIngredient(Ingredient ingredient);

}
