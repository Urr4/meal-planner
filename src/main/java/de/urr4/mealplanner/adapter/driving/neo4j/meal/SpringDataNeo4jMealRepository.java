package de.urr4.mealplanner.adapter.driving.neo4j.meal;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.UUID;

@Repository
public interface SpringDataNeo4jMealRepository extends Neo4jRepository<MealEntity, UUID> {

    @Query("MATCH (m:Meal) RETURN m, rand() ORDER by rand() LIMIT $numberOfMeals")
    Collection<MealEntity> getRandomMeals(@Param("numberOfMeals") int numberOfMeals);
}
