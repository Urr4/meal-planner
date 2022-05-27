package de.urr4.mealplanner.adapter.driving.rest.ingredient;

import de.urr4.mealplanner.adapter.driving.rest.tag.TagDto;
import lombok.Data;

import java.util.Collection;

@Data
public class CreateIngredientRequest {

    private String name;
    private Collection<TagDto> tagDtos;

}
