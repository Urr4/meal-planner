package de.urr4.mealplanner.adapter.driving.rest.meals;

import de.urr4.mealplanner.domain.meal.Meal;
import de.urr4.mealplanner.domain.meal.MealService;
import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/meals")
public class MealController {

    private final Logger LOG = LoggerFactory.getLogger(MealController.class);

    private final MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping
    public Collection<MealDto> getRandomMeals(@RequestParam(value = "numFav", defaultValue = "3") int numberOfFavoriteMeals, @RequestParam(value = "numGen", defaultValue = "2") int numberOfGeneratedMeals) {
        LOG.info("Getting random meal-plan with {} favorite and {} generated meals", numberOfFavoriteMeals, numberOfGeneratedMeals);
        return mealService.getRandomMeals(numberOfFavoriteMeals, numberOfGeneratedMeals).stream().map(MealMapper.getInstance()::toDto).collect(Collectors.toList());
    }

    @GetMapping(path = "/{mealId}")
    public MealDto getMeal(@PathVariable("mealId") UUID mealId) {
        LOG.info("Getting meal {}", mealId);
        return MealMapper.getInstance().toDto(mealService.getMealById(mealId));
    }

    @PostMapping
    public MealDto createMeal(@RequestBody CreateMealRequest createMealRequest) {
        LOG.info("Creating meal for mealId {}", createMealRequest.getMealName());
        return MealMapper.getInstance().toDto(mealService.createMeal(mapToMeal(createMealRequest)));
    }

    @PutMapping
    public void favoriteMeal(@RequestBody FavoriteMealRequest favoriteMealRequest) {
        LOG.info("User {} favorited meal with mealId {}", favoriteMealRequest.getUserId(), favoriteMealRequest.getMealId());
        throw new NotImplementedException(); //TODO implement
    }

    @DeleteMapping(path = "/{mealId}")
    public void deleteMeal(@RequestParam("mealId") UUID mealId) {
        LOG.info("Marking meal with mealId {} as deleted", mealId);
        throw new NotImplementedException(); //TODO implement
    }

    private Meal mapToMeal(CreateMealRequest createMealRequest) {
        return Meal.builder()
                .name(createMealRequest.getMealName())
                .build();
    }
}
