package de.urr4.mealplanner.adapter.driving.neo4j.recipe;

import de.urr4.mealplanner.adapter.driving.neo4j.DomainToEntityMapper;
import de.urr4.mealplanner.adapter.driving.neo4j.ingredient.IngredientDomainToEntityMapper;
import de.urr4.mealplanner.domain.recipe.IngredientDescriptor;

public class IngredientDescriptorDomainToEntityMapper implements DomainToEntityMapper<IngredientDescriptor, IngredientDescriptionRelationshipEntity> {

    private static IngredientDescriptorDomainToEntityMapper instance;

    public static IngredientDescriptorDomainToEntityMapper getInstance() {
        if (instance == null) {
            instance = new IngredientDescriptorDomainToEntityMapper();
        }
        return instance;
    }

    private IngredientDescriptorDomainToEntityMapper() {
    }

    @Override
    public IngredientDescriptionRelationshipEntity toEntity(IngredientDescriptor ingredientDescriptor) {
        IngredientDescriptionRelationshipEntity entity = new IngredientDescriptionRelationshipEntity();
        entity.setId(ingredientDescriptor.getId());
        entity.setIngredientEntity(IngredientDomainToEntityMapper.getInstance().toEntity(ingredientDescriptor.getIngredient()));
        return entity;
    }

    @Override
    public IngredientDescriptor toDomain(IngredientDescriptionRelationshipEntity ingredientDescriptionRelationshipEntity) {
        IngredientDescriptor ingredientDescriptor = new IngredientDescriptor();
        ingredientDescriptor.setId(ingredientDescriptionRelationshipEntity.getId());
        ingredientDescriptor.setIngredient(IngredientDomainToEntityMapper.getInstance().toDomain(ingredientDescriptionRelationshipEntity.getIngredientEntity()));
        return ingredientDescriptor;
    }
}
