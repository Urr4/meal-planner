package de.urr4.mealplanner.adapter.driving.rest.recipe;

import de.urr4.mealplanner.adapter.driving.rest.ingredient.IngredientDto;
import lombok.Data;

@Data
public class IngredientDescriptorDto {
    private Long id;
    private IngredientDto ingredient;
}
