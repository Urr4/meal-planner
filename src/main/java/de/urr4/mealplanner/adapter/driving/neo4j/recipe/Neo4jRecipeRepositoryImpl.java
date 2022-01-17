package de.urr4.mealplanner.adapter.driving.neo4j.recipe;

import de.urr4.mealplanner.domain.recipe.Recipe;
import de.urr4.mealplanner.domain.recipe.RecipeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class Neo4jRecipeRepositoryImpl implements RecipeRepository {

    private final SpringDataNeo4jRepository springDataNeo4jRepository;

    public Neo4jRecipeRepositoryImpl(SpringDataNeo4jRepository springDataNeo4jRepository) {
        this.springDataNeo4jRepository = springDataNeo4jRepository;
    }

    @Override
    public Page<Recipe> getRecipesByPage(Pageable pageable) {
        return springDataNeo4jRepository.findAll(pageable).map(RecipeMapper::toDomain);
    }
}
