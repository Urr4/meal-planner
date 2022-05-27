package de.urr4.mealplanner.application.meal;

import de.urr4.mealplanner.domain.meal.Meal;
import de.urr4.mealplanner.domain.meal.MealService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;

    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public Collection<Meal> getRandomMeals(int numberOfMeals) {
        return mealRepository.getRandomMeals(numberOfMeals);
    }

    @Override
    public Meal createMeal(Meal meal) {
        return mealRepository.createMeal(meal);
    }

    @Override
    public Meal getMealById(UUID mealId) {
        return mealRepository.getMealById(mealId);
    }
}
