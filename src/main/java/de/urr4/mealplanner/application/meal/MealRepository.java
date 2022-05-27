package de.urr4.mealplanner.application.meal;

import de.urr4.mealplanner.domain.meal.Meal;

import java.util.Collection;
import java.util.UUID;

public interface MealRepository {

    Collection<Meal> getRandomMeals(int numberOfMeals);

    Meal createMeal(Meal meal);

    Meal getMealById(UUID mealId);
}
