package de.urr4.mealplanner.adapter.driving.neo4j.ingredient;

import de.urr4.mealplanner.adapter.driving.neo4j.DomainToEntityMapper;
import de.urr4.mealplanner.domain.ingredient.Ingredient;

public class IngredientDomainToEntityMapper implements DomainToEntityMapper<Ingredient, IngredientEntity> {

    private static IngredientDomainToEntityMapper instance;

    public static IngredientDomainToEntityMapper getInstance() {
        if (instance == null) {
            instance = new IngredientDomainToEntityMapper();
        }
        return instance;
    }

    private IngredientDomainToEntityMapper() {
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
