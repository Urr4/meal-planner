package de.urr4.mealplanner.recipe.rest;

import de.urr4.mealplanner.descriptor.rest.CreateIngredientDescriptorRequest;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class CreateRecipeRequest {

    @NotBlank(message = "Name has to be provided")
    @Size(min = 1, max = 100, message = "Has to be between 1 and 100 characters long")
    private String name;

    @Size(max = 1000, message = "Must to be at most 1000 characters long")
    private String description;

    private List<CreateIngredientDescriptorRequest> createIngredientDescriptorRequest = new ArrayList<>();

}
