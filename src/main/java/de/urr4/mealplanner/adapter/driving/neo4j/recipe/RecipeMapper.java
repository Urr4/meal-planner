package de.urr4.mealplanner.adapter.driving.neo4j.recipe;

import de.urr4.mealplanner.domain.recipe.Recipe;

public class RecipeMapper {

    public static RecipeEntity toEntity(Recipe recipe) {
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setId(recipe.getId());
        recipeEntity.setName(recipe.getName());
        recipeEntity.setInstructions(recipe.getInstructions());
        //TODO IngredientDescriptor
        return recipeEntity;
    }

    public static Recipe toDomain(RecipeEntity recipeEntity) {
        Recipe recipe = new Recipe();
        recipe.setId(recipeEntity.getId());
        recipe.setName(recipeEntity.getName());
        recipe.setInstructions(recipeEntity.getInstructions());
        //TODO IngredientDescriptor
        return recipe;
    }
}
