package de.urr4.mealplanner.adapter.driving.neo4j.meal;

import de.urr4.mealplanner.application.meal.MealRepository;
import de.urr4.mealplanner.domain.meal.Meal;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class Neo4jMealRepositoryImpl implements MealRepository {

    private final SpringDataNeo4jMealRepository springDataNeo4jMealRepository;

    public Neo4jMealRepositoryImpl(SpringDataNeo4jMealRepository springDataNeo4jMealRepository) {
        this.springDataNeo4jMealRepository = springDataNeo4jMealRepository;
    }

    @Override
    public Collection<Meal> getRandomMeals(int numberOfMeals) {
        return springDataNeo4jMealRepository.getRandomMeals(numberOfMeals).stream().map(MealDomainToEntityMapper.getInstance()::toDomain).collect(Collectors.toList());
    }

    @Override
    public Meal createMeal(Meal meal) {
        return MealDomainToEntityMapper.getInstance().toDomain(springDataNeo4jMealRepository.save(MealDomainToEntityMapper.getInstance().toEntity(meal)));
    }

    @Override
    public Meal getMealById(UUID mealId) {
        return MealDomainToEntityMapper.getInstance().toDomain(springDataNeo4jMealRepository.findById(mealId).orElseThrow(() -> new IllegalArgumentException(String.format("Could not find meal with id %s", mealId))));
    }
}
