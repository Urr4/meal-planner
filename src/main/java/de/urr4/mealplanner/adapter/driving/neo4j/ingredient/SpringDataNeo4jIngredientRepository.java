package de.urr4.mealplanner.adapter.driving.neo4j.ingredient;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SpringDataNeo4jIngredientRepository extends Neo4jRepository<IngredientEntity, Long> {

}
