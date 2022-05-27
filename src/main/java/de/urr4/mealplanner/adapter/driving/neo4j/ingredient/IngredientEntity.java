package de.urr4.mealplanner.adapter.driving.neo4j.ingredient;

import de.urr4.mealplanner.adapter.driving.neo4j.tag.TagEntity;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.Collection;
import java.util.UUID;

@Data
@Node("Ingredient")
public class IngredientEntity {

    @Id
    @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)
    private UUID id;

    @Property
    private String name;

    @Relationship(type = "TAGGED")
    private Collection<TagEntity> tagEntitys;

}
