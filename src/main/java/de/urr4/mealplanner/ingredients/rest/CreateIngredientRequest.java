package de.urr4.mealplanner.ingredients.rest;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class CreateIngredientRequest {

    @NotBlank(message = "Cannot create ingredients without name")
    @Size(min = 1, max = 100, message = "Must be between 1 and 100 characters long")
    private String name;
}
