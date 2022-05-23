package de.urr4.mealplanner.adapter.driving.rest.ingredient;

import java.util.UUID;

public class UpdateIngredientRequest {

    private UUID ingredientId;
    private String newIngredientName;

    public UUID getIngredientId() {
        return ingredientId;
    }

    public String getNewIngredientName() {
        return newIngredientName;
    }
}
