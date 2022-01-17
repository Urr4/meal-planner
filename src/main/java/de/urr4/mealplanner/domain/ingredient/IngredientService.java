package de.urr4.mealplanner.domain.ingredient;

import org.springframework.data.domain.Page;

public interface IngredientService {

    Page<Ingredient> getIngredientsPage(int pageNumber, int pageSize);

    Ingredient saveIngredient(Ingredient ingredient);

}
