package de.urr4.mealplanner.recipe.rest;

import de.urr4.mealplanner.recipe.RecipeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class RecipePreviewDTO {

    private Long id;
    private String name;
    private String description;

    public static RecipePreviewDTO from(RecipeEntity recipeEntity) {
        return RecipePreviewDTO.builder()
                .id(recipeEntity.getId())
                .name(recipeEntity.getName())
                .description(recipeEntity.getDescription())
                .build();

    }
}
