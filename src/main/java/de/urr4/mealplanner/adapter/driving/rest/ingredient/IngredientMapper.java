package de.urr4.mealplanner.adapter.driving.rest.ingredient;

import de.urr4.mealplanner.domain.ingredient.Ingredient;

public class IngredientMapper {

    public static IngredientDto toDto(Ingredient ingredient){
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setId(ingredient.getId());
        ingredientDto.setName(ingredient.getName());
        return ingredientDto;
    }

    public static Ingredient toDomain(IngredientDto ingredientDto){
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientDto.getId());
        ingredient.setName(ingredientDto.getName());
        return ingredient;
    }
}
