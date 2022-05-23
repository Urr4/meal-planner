package de.urr4.mealplanner.adapter.driving.rest.ingredient;

import java.util.UUID;

public class LikeIngredientRequest {

    private UUID ingredientId;
    private UUID userId;

    public UUID getIngredientId() {
        return ingredientId;
    }

    public UUID getUserId() {
        return userId;
    }
}
