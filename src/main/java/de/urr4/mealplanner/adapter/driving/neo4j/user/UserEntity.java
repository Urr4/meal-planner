package de.urr4.mealplanner.adapter.driving.neo4j.user;

import de.urr4.mealplanner.adapter.driving.neo4j.ingredient.IngredientEntity;
import de.urr4.mealplanner.adapter.driving.neo4j.meal.MealEntity;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.Collection;
import java.util.UUID;

@Data
@Node("User")
public class UserEntity {

    @Id
    @GeneratedValue(generatorClass = GeneratedValue.UUIDGenerator.class)
    private UUID id;

    @Property
    private String name;

    @Relationship(type = "DISLIKES")
    private Collection<IngredientEntity> dislikedIngredients;

    @Relationship(type = "LIKES")
    private Collection<MealEntity> likedMeals;
}
