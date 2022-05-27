package de.urr4.mealplanner.adapter.driving.neo4j.recipe;

import de.urr4.mealplanner.adapter.driving.neo4j.Mapper;
import de.urr4.mealplanner.adapter.driving.neo4j.ingredient.IngredientMapper;
import de.urr4.mealplanner.domain.recipe.IngredientDescriptor;

public class IngredientDescriptorMapper implements Mapper<IngredientDescriptor, IngredientDescriptionRelationshipEntity> {

    private static IngredientDescriptorMapper instance;

    public static IngredientDescriptorMapper getInstance() {
        if (instance == null) {
            instance = new IngredientDescriptorMapper();
        }
        return instance;
    }

    private IngredientDescriptorMapper() {
    }

    @Override
    public IngredientDescriptionRelationshipEntity toEntity(IngredientDescriptor ingredientDescriptor) {
        IngredientDescriptionRelationshipEntity entity = new IngredientDescriptionRelationshipEntity();
        entity.setId(ingredientDescriptor.getId());
        entity.setIngredientEntity(IngredientMapper.getInstance().toEntity(ingredientDescriptor.getIngredient()));
        return entity;
    }

    @Override
    public IngredientDescriptor toDomain(IngredientDescriptionRelationshipEntity ingredientDescriptionRelationshipEntity) {
        IngredientDescriptor ingredientDescriptor = new IngredientDescriptor();
        ingredientDescriptor.setId(ingredientDescriptionRelationshipEntity.getId());
        ingredientDescriptor.setIngredient(IngredientMapper.getInstance().toDomain(ingredientDescriptionRelationshipEntity.getIngredientEntity()));
        return ingredientDescriptor;
    }
}
