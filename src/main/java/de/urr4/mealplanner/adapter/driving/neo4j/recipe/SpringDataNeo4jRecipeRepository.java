package de.urr4.mealplanner.adapter.driving.neo4j.recipe;

import de.urr4.mealplanner.domain.recipe.RecipeType;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.UUID;

public interface SpringDataNeo4jRecipeRepository extends Neo4jRepository<RecipeEntity, UUID> {

    @Query("MATCH (r:Recipe {recipeType: $recipeType}) RETURN r, rand() ORDER by rand() LIMIT $numberOfRecipes")
    Collection<RecipeEntity> getRandomRecipes(@Param("numberOfRecipes") int numberOfRecipes, @Param("recipeType") RecipeType recipeType);

}
