package de.urr4.mealplanner.domain.recipe;

import de.urr4.mealplanner.domain.ingredient.Ingredient;
import lombok.Data;

@Data
public class IngredientDescriptor {

    private Long id;
    private Unit unit;
    private Double amount;
    private Ingredient ingredient;
}
