package de.urr4.mealplanner.adapter.driving.neo4j.recipe;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface SpringDataNeo4jRecipeRepository extends Neo4jRepository<RecipeEntity, UUID> {
}
