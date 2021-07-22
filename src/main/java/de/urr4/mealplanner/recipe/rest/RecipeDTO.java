package de.urr4.mealplanner.recipe.rest;

import de.urr4.mealplanner.recipe.RecipeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class RecipeDTO {

    private Long id;
    private String name;
    private List<IngredientDescriptorDTO> ingredientDescriptors;

    public static RecipeDTO from(RecipeEntity recipeEntity) {
        return RecipeDTO.builder()
                .id(recipeEntity.getId())
                .name(recipeEntity.getName())
                .ingredientDescriptors(recipeEntity.getIngredientDescriptorEntities()
                        .stream()
                        .map(IngredientDescriptorDTO::from)
                        .collect(Collectors.toList()))
                .build();

    }
}
