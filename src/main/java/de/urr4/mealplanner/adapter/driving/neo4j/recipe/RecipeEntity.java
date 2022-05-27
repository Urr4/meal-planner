package de.urr4.mealplanner.adapter.driving.neo4j.recipe;

import de.urr4.mealplanner.adapter.driving.neo4j.tag.TagEntity;
import de.urr4.mealplanner.domain.tag.Tag;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.Collection;
import java.util.UUID;

@Data
@Node("Recipe")
public class RecipeEntity {

    @Id
    @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)
    private UUID id;

    @Property
    private String name;

    @Relationship(type = "CONTAINS")
    private Collection<IngredientDescriptionRelationshipEntity> ingredientDescriptors;

    @Relationship(type = "TAGGED")
    private Collection<TagEntity> tags;

    @Property
    private String instructions;
}
