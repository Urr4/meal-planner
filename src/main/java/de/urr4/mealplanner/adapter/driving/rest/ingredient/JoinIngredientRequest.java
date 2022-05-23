package de.urr4.mealplanner.adapter.driving.rest.ingredient;

import java.util.UUID;

public class JoinIngredientRequest {
    private UUID originalIngredientId;
    private UUID redundantIngredientId;

    public UUID getOriginalIngredientId() {
        return originalIngredientId;
    }

    public UUID getRedundantIngredientId() {
        return redundantIngredientId;
    }
}
