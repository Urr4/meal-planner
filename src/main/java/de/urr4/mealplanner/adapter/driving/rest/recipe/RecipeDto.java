package de.urr4.mealplanner.adapter.driving.rest.recipe;

import lombok.Data;

import java.util.UUID;

@Data
public class RecipeDto {

    private UUID id;
    private String name;
    //    private Collection<IngredientDescriptor> ingredientDescriptors;
    private String instructions;
}
