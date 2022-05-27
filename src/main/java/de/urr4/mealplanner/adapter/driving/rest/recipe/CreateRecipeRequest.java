package de.urr4.mealplanner.adapter.driving.rest.recipe;

import de.urr4.mealplanner.adapter.driving.rest.tag.TagDto;
import lombok.Getter;

import java.util.Collection;

@Getter
public class CreateRecipeRequest {
    private String name;
    private String instructions;

    private Collection<CreateIngredientDescriptorRequest> ingredientDescriptors;
    private Collection<TagDto> tags;
}
