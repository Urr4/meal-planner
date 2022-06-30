package de.urr4.mealplanner.adapter.driving.rest.meals;

import de.urr4.mealplanner.adapter.driving.rest.DomainToDtoMapper;
import de.urr4.mealplanner.adapter.driving.rest.recipe.RecipeMapper;
import de.urr4.mealplanner.domain.meal.Meal;

import java.util.stream.Collectors;

public class MealMapper implements DomainToDtoMapper<MealDto, Meal> {

    private static MealMapper instance;

    public static MealMapper getInstance() {
        if (instance == null) {
            instance = new MealMapper();
        }
        return instance;
    }

    private MealMapper() {
    }

    public MealDto toDto(Meal meal) {
        MealDto dto = new MealDto();
        dto.setId(meal.getId());
        dto.setName(meal.getName());
        dto.setRecipes(meal.getRecipes().stream().map(RecipeMapper.getInstance()::toDto).collect(Collectors.toList()));
        return dto;
    }

    public Meal toDomain(MealDto dto) {
        Meal meal = new Meal();
        meal.setId(dto.getId());
        meal.setName(dto.getName());
        meal.setRecipes(dto.getRecipes().stream().map(RecipeMapper.getInstance()::toDomain).collect(Collectors.toList()));
        return meal;
    }
}