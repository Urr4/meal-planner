package de.urr4.mealplanner.adapter.driving.rest.meals;

import de.urr4.mealplanner.adapter.driving.rest.recipe.RecipeMapper;
import de.urr4.mealplanner.domain.meal.Meal;
import de.urr4.mealplanner.domain.meal.MealService;
import de.urr4.mealplanner.domain.recipe.Recipe;
import de.urr4.mealplanner.domain.recipe.RecipeService;
import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
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
    private final RecipeService recipeService;

    public MealController(MealService mealService, RecipeService recipeService) {
        this.mealService = mealService;
        this.recipeService = recipeService;
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
    @Transactional
    public MealDto createMeal(@RequestBody CreateMealRequest createMealRequest) {
        LOG.info("Creating meal with name {} and {} recipes", createMealRequest.getMealName(), createMealRequest.getRecipeIds().size());
        Collection<Recipe> recipes = recipeService.getRecipesByIds(createMealRequest.getRecipeIds());
        Meal meal = Meal.builder()
                .name(createMealRequest.getMealName())
                .recipes(recipes)
                .build();
        return MealMapper.getInstance().toDto(mealService.createMeal(meal));
    }

    @DeleteMapping(path = "/{mealId}")
    public void deleteMeal(@RequestParam("mealId") UUID mealId) {
        LOG.info("Marking meal with mealId {} as deleted", mealId);
        throw new NotImplementedException(); //TODO implement
    }

}
