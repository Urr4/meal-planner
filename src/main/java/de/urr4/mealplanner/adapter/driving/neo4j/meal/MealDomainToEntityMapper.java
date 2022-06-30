package de.urr4.mealplanner.adapter.driving.neo4j.meal;

import de.urr4.mealplanner.adapter.driving.neo4j.DomainToEntityMapper;
import de.urr4.mealplanner.adapter.driving.neo4j.recipe.RecipeDomainToEntityMapper;
import de.urr4.mealplanner.domain.meal.Meal;

import java.util.stream.Collectors;

public class MealDomainToEntityMapper implements DomainToEntityMapper<Meal, MealEntity> {

    private static MealDomainToEntityMapper instance;

    public static MealDomainToEntityMapper getInstance() {
        if (instance == null) {
            instance = new MealDomainToEntityMapper();
        }
        return instance;
    }

    private MealDomainToEntityMapper() {
    }

    public MealEntity toEntity(Meal domain) {
        MealEntity mealEntity = new MealEntity();
        mealEntity.setId(domain.getId());
        mealEntity.setName(domain.getName());
        mealEntity.setRecipeEntitys(domain.getRecipes().stream().map(RecipeDomainToEntityMapper.getInstance()::toEntity).collect(Collectors.toList()));
        return mealEntity;
    }

    public Meal toDomain(MealEntity mealEntity) {
        Meal meal = new Meal();
        meal.setId(mealEntity.getId());
        meal.setName(mealEntity.getName());
        meal.setRecipes(mealEntity.getRecipeEntitys().stream().map(RecipeDomainToEntityMapper.getInstance()::toDomain).collect(Collectors.toList()));
        return meal;
    }
}
