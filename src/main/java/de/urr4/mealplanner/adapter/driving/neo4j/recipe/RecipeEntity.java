package de.urr4.mealplanner.adapter.driving.neo4j.recipe;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Data
@Node("Recipe")
public class RecipeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String name;

//    @Relationship(type = "CONTAINS")
//    private Collection<IngredientDescriptor> ingredientDescriptors;

    @Property
    private String instructions;
}
