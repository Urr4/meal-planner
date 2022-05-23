package de.urr4.mealplanner.adapter.driving.rest.meals;

import lombok.Data;

import java.util.Collection;

@Data
public class MealPlanDto {
    private Collection<MealDto> meals;
}
