package de.urr4.mealplanner.adapter.driving.rest.recipe;

import de.urr4.mealplanner.adapter.driving.rest.ingredient.IngredientMapper;
import de.urr4.mealplanner.domain.recipe.IngredientDescriptor;

public class IngredientDescriptorMapper {

    public static IngredientDescriptorDto toDto(IngredientDescriptor ingredientDescriptor) {
        IngredientDescriptorDto ingredientDescriptorDto = new IngredientDescriptorDto();
        ingredientDescriptorDto.setId(ingredientDescriptor.getId());
        ingredientDescriptorDto.setIngredient(IngredientMapper.getInstance().toDto(ingredientDescriptor.getIngredient()));
        return ingredientDescriptorDto;
    }

    public static IngredientDescriptor toDomain(IngredientDescriptorDto ingredientDescriptorDto) {
        IngredientDescriptor ingredientDescriptor = new IngredientDescriptor();
        ingredientDescriptor.setId(ingredientDescriptorDto.getId());
        ingredientDescriptor.setIngredient(IngredientMapper.getInstance().toDomain(ingredientDescriptorDto.getIngredient()));
        return ingredientDescriptor;
    }
}
