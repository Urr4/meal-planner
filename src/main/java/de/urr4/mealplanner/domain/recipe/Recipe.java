package de.urr4.mealplanner.domain.recipe;

import lombok.Data;

import java.util.UUID;

@Data
public class Recipe {

    private UUID id;
    private String name;

//    private List<IngredientDescriptor> ingredientDescriptors;

    private String instructions;
}
