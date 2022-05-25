package de.urr4.mealplanner.adapter.driving.neo4j.ingredient;

import de.urr4.mealplanner.adapter.driving.neo4j.Mapper;
import de.urr4.mealplanner.domain.ingredient.Ingredient;

public class IngredientMapper implements Mapper<Ingredient, IngredientEntity> {

    private static IngredientMapper instance;

    public static IngredientMapper getInstance() {
        if (instance == null) {
            instance = new IngredientMapper();
        }
        return instance;
    }

    private IngredientMapper() {
    }

    public IngredientEntity toEntity(Ingredient domain) {
        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setId(domain.getId());
        ingredientEntity.setName(domain.getName());
        return ingredientEntity;
    }

    public Ingredient toDomain(IngredientEntity ingredientEntity) {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientEntity.getId());
        ingredient.setName(ingredientEntity.getName());
        return ingredient;
    }
}
