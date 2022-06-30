package de.urr4.mealplanner.adapter.driving.rest.ingredient;

import de.urr4.mealplanner.adapter.driving.rest.DomainToDtoMapper;
import de.urr4.mealplanner.domain.ingredient.Ingredient;

public class IngredientMapper implements DomainToDtoMapper<IngredientDto, Ingredient> {

    private static IngredientMapper instance;

    public static IngredientMapper getInstance() {
        if (instance == null) {
            instance = new IngredientMapper();
        }
        return instance;
    }

    private IngredientMapper() {
    }

    public IngredientDto toDto(Ingredient ingredient) {
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setId(ingredient.getId());
        ingredientDto.setName(ingredient.getName());
        return ingredientDto;
    }

    public Ingredient toDomain(IngredientDto ingredientDto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(ingredientDto.getId());
        ingredient.setName(ingredientDto.getName());
        return ingredient;
    }
}
