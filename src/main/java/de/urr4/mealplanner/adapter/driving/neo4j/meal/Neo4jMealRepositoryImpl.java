package de.urr4.mealplanner.adapter.driving.neo4j.meal;

import de.urr4.mealplanner.application.meal.MealRepository;
import org.springframework.stereotype.Service;

@Service
public class Neo4jMealRepositoryImpl implements MealRepository {

    private final SpringDataNeo4jMealRepository springDataNeo4jMealRepository;

    public Neo4jMealRepositoryImpl(SpringDataNeo4jMealRepository springDataNeo4jMealRepository) {
        this.springDataNeo4jMealRepository = springDataNeo4jMealRepository;
    }

}
