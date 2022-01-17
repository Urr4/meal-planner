package de.urr4.mealplanner.adapter.driving.rest.recipe;

import de.urr4.mealplanner.adapter.driving.neo4j.recipe.RecipeEntity;
import de.urr4.mealplanner.domain.recipe.Recipe;

public class RecipeMapper {

    public static RecipeDto toDto(Recipe recipe){
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(recipe.getId());
        recipeDto.setName(recipe.getName());
        recipeDto.setInstructions(recipe.getInstructions());
        //TODO IngredientDescriptor
        return recipeDto;
    }

    public static Recipe toDomain(RecipeDto recipeDto){
        Recipe recipe = new Recipe();
        recipe.setId(recipeDto.getId());
        recipe.setName(recipeDto.getName());
        recipe.setInstructions(recipeDto.getInstructions());
        //TODO IngredientDescriptor
        return recipe;
    }

}
