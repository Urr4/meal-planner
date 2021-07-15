package de.urr4.mealplanner.ingredients;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class IngredientDTO {

    private Long id;
    private String name;

    public static IngredientDTO from(IngredientEntity ingredientEntity) {
        return IngredientDTO.builder()
                .id(ingredientEntity.getId())
                .name(ingredientEntity.getName())
                .build();
    }
}
