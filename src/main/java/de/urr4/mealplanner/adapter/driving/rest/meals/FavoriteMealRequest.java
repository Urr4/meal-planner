package de.urr4.mealplanner.adapter.driving.rest.meals;

import java.util.UUID;

public class FavoriteMealRequest {
    private UUID mealId;
    private String mealName;
    private UUID userId;

    public UUID getMealId() {
        return mealId;
    }

    public UUID getUserId() {
        return userId;
    }
}
