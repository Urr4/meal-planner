package de.urr4.mealplanner.descriptor.rest;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class UpdateIngredientDescritorRequest extends IngredientDescriptorRequest{

    @NotNull(message = "ID must be set")
    private Long id;

}
