package de.urr4.mealplanner.domain.recipe;

import de.urr4.mealplanner.domain.tag.Tag;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Data
public class Recipe {

    private UUID id;
    private String name;
    private RecipeType recipeType;
    private String instructions;

    private Collection<IngredientDescriptor> ingredientDescriptors = new ArrayList<>();
    private Collection<Tag> tags;

}
