package de.urr4.mealplanner.recipe.rest;

import de.urr4.mealplanner.recipe.RecipeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class RecipeDetailsDTO {

    private Long id;
    private String name;
    private String description;
    private List<IngredientDescriptorDTO> ingredientDescriptors;

    public static RecipeDetailsDTO from(RecipeEntity recipeEntity) {
        return RecipeDetailsDTO.builder()
                .id(recipeEntity.getId())
                .name(recipeEntity.getName())
                .description(recipeEntity.getDescription())
                .ingredientDescriptors(recipeEntity.getIngredientDescriptorEntities()
                        .stream()
                        .map(IngredientDescriptorDTO::from)
                        .collect(Collectors.toList())
                )
                .build();

    }
}
