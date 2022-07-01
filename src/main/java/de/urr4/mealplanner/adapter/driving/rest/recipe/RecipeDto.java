package de.urr4.mealplanner.adapter.driving.rest.recipe;

import de.urr4.mealplanner.adapter.driving.rest.tag.TagDto;
import de.urr4.mealplanner.domain.recipe.RecipeType;
import lombok.Data;

import java.util.Collection;
import java.util.UUID;

@Data
public class RecipeDto {

    private UUID id;
    private String name;
    private String instructions;
    private RecipeType recipeType;
    private Collection<IngredientDescriptorDto> ingredientDescriptors;
    private Collection<TagDto> tags;
}
