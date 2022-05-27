package de.urr4.mealplanner.adapter.driving.neo4j.recipe;

import de.urr4.mealplanner.adapter.driving.neo4j.Mapper;
import de.urr4.mealplanner.adapter.driving.neo4j.tag.TagMapper;
import de.urr4.mealplanner.domain.recipe.Recipe;

import java.util.stream.Collectors;

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
        recipeEntity.setIngredientDescriptors(domain.getIngredientDescriptors().stream().map(IngredientDescriptorMapper.getInstance()::toEntity).collect(Collectors.toList()));
        recipeEntity.setTags(domain.getTags().stream().map(TagMapper.getInstance()::toEntity).collect(Collectors.toList()));
        return recipeEntity;
    }

    public Recipe toDomain(RecipeEntity recipeEntity) {
        Recipe recipe = new Recipe();
        recipe.setId(recipeEntity.getId());
        recipe.setName(recipeEntity.getName());
        recipe.setInstructions(recipeEntity.getInstructions());
        recipe.setIngredientDescriptors(recipeEntity.getIngredientDescriptors().stream().map(IngredientDescriptorMapper.getInstance()::toDomain).collect(Collectors.toList()));
        recipe.setTags(recipeEntity.getTags().stream().map(TagMapper.getInstance()::toDomain).collect(Collectors.toList()));
        return recipe;
    }
}
