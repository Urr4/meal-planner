package de.urr4.mealplanner.domain.meal;

import java.util.Collection;
import java.util.UUID;

public interface MealService {

    Collection<Meal> getRandomMeals(int numberOfFavoriteMeal, int numberOfGeneratedMeals);

    Meal createMeal(Meal meal);

    Meal getMealById(UUID mealId);
}
