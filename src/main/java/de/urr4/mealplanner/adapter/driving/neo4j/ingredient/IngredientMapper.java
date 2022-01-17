package de.urr4.mealplanner.adapter.driving.neo4j.ingredient;

import de.urr4.mealplanner.domain.ingredient.Ingredient;

public class IngredientMapper {

    public static IngredientEntity toEntity(Ingredient ingredient){
        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setId(ingredient.getId());
        ingredientEntity.setName(ingredient.getName());
        return ingredientEntity;
    }

    public static Ingredient toDomain(IngredientEntity ingredientEntity){
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientEntity.getId());
        ingredient.setName(ingredientEntity.getName());
        return ingredient;
    }
}
