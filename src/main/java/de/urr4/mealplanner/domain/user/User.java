package de.urr4.mealplanner.domain.user;

import de.urr4.mealplanner.domain.ingredient.Ingredient;
import de.urr4.mealplanner.domain.meal.Meal;
import lombok.Data;

import java.util.Collection;
import java.util.UUID;

@Data
public class User {

    private UUID id;
    private String name;

    private Collection<Ingredient> dislikedIngredients;
    private Collection<Meal> favoriteMeals;

}
