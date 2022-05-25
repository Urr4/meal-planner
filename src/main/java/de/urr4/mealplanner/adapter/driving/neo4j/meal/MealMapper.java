package de.urr4.mealplanner.adapter.driving.neo4j.meal;

import de.urr4.mealplanner.adapter.driving.neo4j.Mapper;
import de.urr4.mealplanner.adapter.driving.neo4j.recipe.RecipeMapper;
import de.urr4.mealplanner.domain.meal.Meal;

import java.util.stream.Collectors;

public class MealMapper implements Mapper<Meal, MealEntity> {

    private static MealMapper instance;

    public static MealMapper getInstance() {
        if (instance == null) {
            instance = new MealMapper();
        }
        return instance;
    }

    private MealMapper() {
    }

    public MealEntity toEntity(Meal domain) {
        MealEntity mealEntity = new MealEntity();
        mealEntity.setId(domain.getId());
        mealEntity.setName(domain.getName());
        mealEntity.setRecipeEntitys(domain.getRecipes().stream().map(RecipeMapper.getInstance()::toEntity).collect(Collectors.toList()));
        return mealEntity;
    }

    public Meal toDomain(MealEntity mealEntity) {
        Meal meal = new Meal();
        meal.setId(mealEntity.getId());
        meal.setName(mealEntity.getName());
        meal.setRecipes(mealEntity.getRecipeEntitys().stream().map(RecipeMapper.getInstance()::toDomain).collect(Collectors.toList()));
        return meal;
    }
}
