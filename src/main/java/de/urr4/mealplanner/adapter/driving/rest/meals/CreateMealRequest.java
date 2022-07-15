package de.urr4.mealplanner.adapter.driving.rest.meals;

import java.util.Collection;
import java.util.UUID;

public class CreateMealRequest {
    private String mealName;
    private Collection<UUID> recipeIds;

    public String getMealName() {
        return mealName;
    }

    public Collection<UUID> getRecipeIds() {
        return recipeIds;
    }
}
