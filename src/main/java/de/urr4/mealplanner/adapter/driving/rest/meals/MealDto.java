package de.urr4.mealplanner.adapter.driving.rest.meals;

import de.urr4.mealplanner.adapter.driving.rest.recipe.RecipeDto;
import lombok.Data;

import java.util.Collection;
import java.util.UUID;

@Data
public class MealDto {
    private UUID id;
    private boolean isGenerated;
    private String name;
    private Collection<RecipeDto> recipes;
}
