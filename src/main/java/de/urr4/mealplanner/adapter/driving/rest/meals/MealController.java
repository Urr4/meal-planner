package de.urr4.mealplanner.adapter.driving.rest.meals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/meals")
public class MealController {

    private final Logger LOG = LoggerFactory.getLogger(MealController.class);

    @GetMapping
    public MealPlanDto getRandomMealPlan(@RequestParam(value = "numberOfMeals", defaultValue = "0") int numberOfMeals) {
        LOG.info("Getting random meal-plan with {} meals", numberOfMeals);
        return new MealPlanDto(); //TODO implement
    }

    @GetMapping(path = "/{mealId}")
    public MealDto getMeal(@PathVariable("mealId") UUID mealId) {
        LOG.info("Getting meal {}", mealId);
        return new MealDto(); //TODO implement
    }

    @PostMapping
    public MealDto createMeal(@RequestBody CreateMealRequest createMealRequest) {
        LOG.info("Creating meal for mealId {}", createMealRequest.getMealName());
        return new MealDto(); //TODO implement
    }

    @PutMapping
    public void favoriteMeal(@RequestBody FavoriteMealRequest favoriteMealRequest) {
        LOG.info("User {} favorited meal with mealId {}", favoriteMealRequest.getUserId(), favoriteMealRequest.getMealId());
        //TODO implement
    }

    @DeleteMapping(path = "/{mealId}")
    public void deleteMeal(@RequestParam("mealId") UUID mealId) {
        LOG.info("Marking meal with mealId {} as deleted", mealId);
        //TODO implement
    }
}
