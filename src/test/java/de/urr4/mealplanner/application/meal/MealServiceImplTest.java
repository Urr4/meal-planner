package de.urr4.mealplanner.application.meal;

import de.urr4.mealplanner.application.recipe.RecipeRepository;
import de.urr4.mealplanner.domain.meal.Meal;
import de.urr4.mealplanner.domain.meal.MealService;
import de.urr4.mealplanner.domain.recipe.Recipe;
import de.urr4.mealplanner.domain.recipe.RecipeType;
import de.urr4.mealplanner.test.TestObjectFactory;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MealServiceImplTest {

    private final MealRepository mealRepository = mock(MealRepository.class);
    private final RecipeRepository recipeRepository = mock(RecipeRepository.class);
    private final Random random = mock(Random.class);

    private final MealService mealService = new MealServiceImpl(mealRepository, recipeRepository, random);

    @Test
    void getRandomMeals() {
        Recipe onlyRecipe = TestObjectFactory.recipe().withRecipeType(RecipeType.ONLY).build();
        Recipe mainRecipe = TestObjectFactory.recipe().withRecipeType(RecipeType.MAIN).build();
        Recipe sideRecipe1 = TestObjectFactory.recipe().withRecipeType(RecipeType.SIDE).build();
        Recipe sideRecipe2 = TestObjectFactory.recipe().withRecipeType(RecipeType.SIDE).build();
        Recipe sauceRecipe = TestObjectFactory.recipe().withRecipeType(RecipeType.SAUCE).build();

        when(recipeRepository.getRandomRecipes(anyInt(), eq(RecipeType.ONLY))).thenReturn(List.of(onlyRecipe));
        when(recipeRepository.getRandomRecipes(anyInt(), eq(RecipeType.MAIN))).thenReturn(List.of(mainRecipe));
        when(recipeRepository.getRandomRecipes(anyInt(), eq(RecipeType.SIDE))).thenReturn(List.of(sideRecipe1, sideRecipe2));
        when(recipeRepository.getRandomRecipes(anyInt(), eq(RecipeType.SAUCE))).thenReturn(List.of(sauceRecipe));

        Meal loadedMeal = Meal.builder().build();
        when(mealRepository.getRandomMeals(anyInt())).thenReturn(List.of(loadedMeal));

        when(random.nextInt(anyInt())).thenReturn(1);

        Collection<Meal> randomMeals = mealService.getRandomMeals(0, 0);

        // There should be 3 meal: 2 generated (1 Only-Meal, 1 One with a MAIN) and 1 loaded from the DB
        assertThat(randomMeals.size()).isEqualTo(3);
        Meal onlyMeal = randomMeals.stream()
                .filter(meal -> meal.getRecipes()
                        .stream()
                        .anyMatch(recipe -> RecipeType.ONLY.equals(recipe.getRecipeType())))
                .findAny()
                .orElseThrow();

        Meal mainMeal = randomMeals.stream()
                .filter(meal -> meal.getRecipes()
                        .stream()
                        .anyMatch(recipe -> RecipeType.MAIN.equals(recipe.getRecipeType())))
                .findAny()
                .orElseThrow();

        assertThat(onlyMeal.getRecipes().size()).isEqualTo(1);
        assertThat(onlyMeal.getRecipes().iterator().next()).isEqualTo(onlyRecipe);

        assertThat(mainMeal.getRecipes().size()).isEqualTo(4);
        assertThat(mainMeal.getRecipes()).containsExactlyInAnyOrderElementsOf(List.of(mainRecipe, sideRecipe1, sideRecipe2, sauceRecipe));

        assertThat(randomMeals).contains(loadedMeal);

    }
}