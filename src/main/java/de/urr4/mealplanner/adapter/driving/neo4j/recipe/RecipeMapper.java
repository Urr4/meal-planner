package de.urr4.mealplanner.adapter.driving.neo4j.recipe;

import de.urr4.mealplanner.adapter.driving.neo4j.Mapper;
import de.urr4.mealplanner.domain.recipe.Recipe;

public class RecipeMapper implements Mapper<Recipe, RecipeEntity> {

    private static RecipeMapper instance;

    public static RecipeMapper getInstance() {
        if (instance == null) {
            instance = new RecipeMapper();
        }
        return instance;
    }

    private RecipeMapper() {
    }

    public RecipeEntity toEntity(Recipe domain) {
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setId(domain.getId());
        recipeEntity.setName(domain.getName());
        recipeEntity.setInstructions(domain.getInstructions());
        //TODO IngredientDescriptor
        return recipeEntity;
    }

    public Recipe toDomain(RecipeEntity recipeEntity) {
        Recipe recipe = new Recipe();
        recipe.setId(recipeEntity.getId());
        recipe.setName(recipeEntity.getName());
        recipe.setInstructions(recipeEntity.getInstructions());
        //TODO IngredientDescriptor
        return recipe;
    }
}
