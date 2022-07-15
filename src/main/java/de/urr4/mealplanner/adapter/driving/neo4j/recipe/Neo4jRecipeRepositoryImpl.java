package de.urr4.mealplanner.adapter.driving.neo4j.recipe;

import de.urr4.mealplanner.application.recipe.RecipeRepository;
import de.urr4.mealplanner.domain.recipe.Recipe;
import de.urr4.mealplanner.domain.recipe.RecipeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class Neo4jRecipeRepositoryImpl implements RecipeRepository {

    private final SpringDataNeo4jRecipeRepository springDataNeo4JRecipeRepository;

    public Neo4jRecipeRepositoryImpl(SpringDataNeo4jRecipeRepository springDataNeo4JRecipeRepository) {
        this.springDataNeo4JRecipeRepository = springDataNeo4JRecipeRepository;
    }

    @Override
    public Page<Recipe> getRecipesByPage(Pageable pageable) {
        return springDataNeo4JRecipeRepository.findAll(pageable).map(RecipeDomainToEntityMapper.getInstance()::toDomain);
    }

    @Override
    public Collection<Recipe> getRandomRecipes(int amount, RecipeType recipeType) {
        return springDataNeo4JRecipeRepository.getRandomRecipes(amount, recipeType).stream().map(RecipeDomainToEntityMapper.getInstance()::toDomain).collect(Collectors.toList());
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return RecipeDomainToEntityMapper.getInstance().toDomain(springDataNeo4JRecipeRepository.save(RecipeDomainToEntityMapper.getInstance().toEntity(recipe)));
    }

    @Override
    public Recipe getRecipeById(UUID id) {
        Optional<RecipeEntity> optional = springDataNeo4JRecipeRepository.findById(id);
        return RecipeDomainToEntityMapper.getInstance().toDomain(optional.orElseThrow(() -> new NotFoundException(String.format("Could not find Recipe %s", id))));
    }

    @Override
    public Collection<Recipe> getRecipesById(Collection<UUID> ids) {
        return springDataNeo4JRecipeRepository.findAllById(ids).stream().map(RecipeDomainToEntityMapper.getInstance()::toDomain).collect(Collectors.toList());
    }
}
