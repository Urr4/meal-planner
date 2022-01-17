package de.urr4.mealplanner.adapter.driving.rest.recipe;

import lombok.Data;

@Data
public class RecipeDto {

    private Long id;
    private String name;
    //    private Collection<IngredientDescriptor> ingredientDescriptors;
    private String instructions;
}
