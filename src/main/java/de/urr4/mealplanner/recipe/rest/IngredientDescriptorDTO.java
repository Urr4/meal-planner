package de.urr4.mealplanner.recipe.rest;

import de.urr4.mealplanner.ingredients.rest.IngredientDTO;
import de.urr4.mealplanner.recipe.IngredientDescriptorEntity;
import de.urr4.mealplanner.recipe.Unit;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class IngredientDescriptorDTO {

    private Long id;
    private Unit unit;
    private Double amount;
    private IngredientDTO ingredient;

    public static IngredientDescriptorDTO from(IngredientDescriptorEntity ingredientDescriptorEntity) {
        return IngredientDescriptorDTO.builder()
                .id(ingredientDescriptorEntity.getId())
                .unit(ingredientDescriptorEntity.getUnit())
                .amount(ingredientDescriptorEntity.getAmount())
                .ingredient(IngredientDTO.from(ingredientDescriptorEntity.getIngredientEntity()))
                .build();
    }
}
