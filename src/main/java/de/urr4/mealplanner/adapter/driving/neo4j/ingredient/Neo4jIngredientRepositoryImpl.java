package de.urr4.mealplanner.adapter.driving.neo4j.ingredient;

import de.urr4.mealplanner.domain.ingredient.Ingredient;
import de.urr4.mealplanner.domain.ingredient.IngredientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Neo4jIngredientRepositoryImpl implements IngredientRepository {

    private final SpringDataNeo4jIngredientRepository springDataNeo4jIngredientRepository;

    public Neo4jIngredientRepositoryImpl(SpringDataNeo4jIngredientRepository springDataNeo4jIngredientRepository) {
        this.springDataNeo4jIngredientRepository = springDataNeo4jIngredientRepository;
    }

    @Override
    public Page<Ingredient> loadIngredientsPage(int pageNumber, int pageSize) {
        return springDataNeo4jIngredientRepository.findAll(PageRequest.of(pageNumber, pageSize))
                .map(IngredientDomainToEntityMapper.getInstance()::toDomain);
    }

    @Override
    public Ingredient saveIngredient(Ingredient ingredient) {
        IngredientEntity ingredientEntity = springDataNeo4jIngredientRepository.save(IngredientDomainToEntityMapper.getInstance().toEntity(ingredient));
        return IngredientDomainToEntityMapper.getInstance().toDomain(ingredientEntity);
    }

    @Override
    public Ingredient getIngredientById(UUID ingredientId) {
        return IngredientDomainToEntityMapper.getInstance().toDomain(springDataNeo4jIngredientRepository.findById(ingredientId).orElseThrow(() -> new IllegalArgumentException(String.format("Could not find ingredient with id %s", ingredientId))));
    }

}
