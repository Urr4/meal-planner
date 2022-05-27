package de.urr4.mealplanner.adapter.driving.rest.recipe;

import de.urr4.mealplanner.adapter.driving.rest.tag.TagDto;
import lombok.Data;

import java.util.Collection;
import java.util.UUID;

@Data
public class RecipeDto {

    private UUID id;
    private String name;
    private String instructions;
    private Collection<IngredientDescriptorDto> ingredientDescriptors;
    private Collection<TagDto> tags;
}
