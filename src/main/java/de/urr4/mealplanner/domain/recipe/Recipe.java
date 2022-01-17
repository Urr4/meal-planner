package de.urr4.mealplanner.domain.recipe;

import lombok.Data;

@Data
public class Recipe {

    private Long id;
    private String name;

//    private List<IngredientDescriptor> ingredientDescriptors;

    private String instructions;
}
