package de.urr4.mealplanner.application.meal;

import de.urr4.mealplanner.application.recipe.RecipeRepository;
import de.urr4.mealplanner.domain.meal.Meal;
import de.urr4.mealplanner.domain.meal.MealService;
import de.urr4.mealplanner.domain.recipe.Recipe;
import de.urr4.mealplanner.domain.recipe.RecipeType;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;
    private final RecipeRepository recipeRepository;
    private final Random random;

    public MealServiceImpl(MealRepository mealRepository, RecipeRepository recipeRepository, Random random) {
        this.mealRepository = mealRepository;
        this.recipeRepository = recipeRepository;
        this.random = random;
    }

    @Override
    public Collection<Meal> getRandomMeals(int numberOfFavoriteMeal, int numberOfGeneratedMeals) {

        int numberOfOnlys = random.nextInt(numberOfGeneratedMeals + 1);
        int numberOfMains = numberOfGeneratedMeals - numberOfOnlys;

        Collection<Recipe> onlyRecipes = new HashSet<>(recipeRepository.getRandomRecipes(numberOfOnlys, RecipeType.ONLY));

        List<Recipe> mains = new ArrayList<>(recipeRepository.getRandomRecipes(numberOfMains, RecipeType.MAIN));
        List<Recipe> sides = new ArrayList<>(recipeRepository.getRandomRecipes(numberOfMains * 2, RecipeType.SIDE));
        List<Recipe> sauces = new ArrayList<>(recipeRepository.getRandomRecipes(numberOfMains, RecipeType.SAUCE));

        Collections.shuffle(sides);
        Collections.shuffle(sauces);

        Stack<Recipe> mainStack = new Stack<>();
        mainStack.addAll(mains);
        Stack<Recipe> sideStack = new Stack<>();
        sideStack.addAll(sides);
        Stack<Recipe> sauceStack = new Stack<>();
        sauceStack.addAll(sauces);

        String generatedMealName = "Generated Meal";
        Collection<Meal> meals = new ArrayList<>(onlyRecipes.stream()
                .map(recipe -> Meal.builder()
                        .recipes(List.of(recipe))
                        .name(generatedMealName)
                        .build())
                .collect(Collectors.toList()));

        while (!mainStack.isEmpty()) {
            Collection<Recipe> mealRecipes = new ArrayList<>();

            mealRecipes.add(mainStack.pop());
            mealRecipes.add(sideStack.pop());
            mealRecipes.add(sideStack.pop());
            mealRecipes.add(sauceStack.pop());

            meals.add(
                    Meal.builder()
                            .name(generatedMealName)
                            .recipes(mealRecipes)
                            .build()
            );
        }

        meals.addAll(mealRepository.getRandomMeals(numberOfFavoriteMeal));

        return meals;
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
