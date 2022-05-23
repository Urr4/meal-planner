package de.urr4.mealplanner.adapter.driving.neo4j.meal;

import de.urr4.mealplanner.adapter.driving.neo4j.recipe.RecipeEntity;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.Collection;
import java.util.UUID;

@Data
@Node("Meal")
public class MealEntity {

    @Id
    @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)
    private UUID id;

    @Property
    private String name;

    @Relationship(type = "CONSISTS_OF")
    private Collection<RecipeEntity> recipeEntitys;

}
