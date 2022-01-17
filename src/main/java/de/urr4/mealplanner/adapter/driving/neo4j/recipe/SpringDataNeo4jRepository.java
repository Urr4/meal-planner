package de.urr4.mealplanner.adapter.driving.neo4j.recipe;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SpringDataNeo4jRepository extends Neo4jRepository<RecipeEntity, Long> {
}
