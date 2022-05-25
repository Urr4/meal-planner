package de.urr4.mealplanner.domain.recipe;

import de.urr4.mealplanner.domain.ingredient.Ingredient;
import lombok.Data;

import java.util.UUID;

@Data
public class IngredientDescriptor {

    private UUID id;
    private Unit unit;
    private Double amount;
    private Ingredient ingredient;
}
