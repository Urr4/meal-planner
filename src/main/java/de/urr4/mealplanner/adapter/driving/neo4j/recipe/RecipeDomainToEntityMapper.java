package de.urr4.mealplanner.adapter.driving.neo4j.recipe;

import de.urr4.mealplanner.adapter.driving.neo4j.DomainToEntityMapper;
import de.urr4.mealplanner.adapter.driving.neo4j.tag.TagDomainToEntityMapper;
import de.urr4.mealplanner.domain.recipe.Recipe;

import java.util.stream.Collectors;

public class RecipeDomainToEntityMapper implements DomainToEntityMapper<Recipe, RecipeEntity> {

    private static RecipeDomainToEntityMapper instance;

    public static RecipeDomainToEntityMapper getInstance() {
        if (instance == null) {
            instance = new RecipeDomainToEntityMapper();
        }
        return instance;
    }

    private RecipeDomainToEntityMapper() {
    }

    public RecipeEntity toEntity(Recipe domain) {
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setId(domain.getId());
        recipeEntity.setName(domain.getName());
        recipeEntity.setInstructions(domain.getInstructions());
        recipeEntity.setIngredientDescriptors(domain.getIngredientDescriptors().stream().map(IngredientDescriptorDomainToEntityMapper.getInstance()::toEntity).collect(Collectors.toList()));
        recipeEntity.setTags(domain.getTags().stream().map(TagDomainToEntityMapper.getInstance()::toEntity).collect(Collectors.toList()));
        return recipeEntity;
    }

    public Recipe toDomain(RecipeEntity recipeEntity) {
        Recipe recipe = new Recipe();
        recipe.setId(recipeEntity.getId());
        recipe.setName(recipeEntity.getName());
        recipe.setInstructions(recipeEntity.getInstructions());
        recipe.setIngredientDescriptors(recipeEntity.getIngredientDescriptors().stream().map(IngredientDescriptorDomainToEntityMapper.getInstance()::toDomain).collect(Collectors.toList()));
        recipe.setTags(recipeEntity.getTags().stream().map(TagDomainToEntityMapper.getInstance()::toDomain).collect(Collectors.toList()));
        return recipe;
    }
}
