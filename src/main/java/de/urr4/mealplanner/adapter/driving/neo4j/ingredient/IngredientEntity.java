package de.urr4.mealplanner.adapter.driving.neo4j.ingredient;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Data
@Node("Ingredient")
public class IngredientEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String name;

}
