package de.urr4.mealplanner.adapter.driving.neo4j.recipe;


import de.urr4.mealplanner.adapter.driving.neo4j.ingredient.IngredientEntity;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@Data
@RelationshipProperties
public class IngredientDescriptionRelationshipEntity {

    @Id
    @GeneratedValue
    private Long id;

    @TargetNode
    private IngredientEntity ingredientEntity;
}
