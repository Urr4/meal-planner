package de.urr4.mealplanner.recipe.rest;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class CreateRecipeRequest {

    @NotBlank(message = "Name has to be provided")
    @Size(min = 1, max = 100, message = "Has to be between 1 and 100 characters long")
    private String name;
}
