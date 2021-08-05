package de.urr4.mealplanner.recipe.rest;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@ToString
public class UpdateRecipeRequest {

    @NotNull(message = "Cannot update recipe without an id")
    private Long id;

    @NotBlank(message = "Name has to be provided")
    @Size(min = 1, max = 100, message = "Has to be between 1 and 100 characters long")
    private String name;

    @Size(max = 1000, message = "Must to be at most 1000 characters long")
    private String description;
}

