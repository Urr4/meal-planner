package de.urr4.mealplanner.adapter.driving.neo4j.user;

import de.urr4.mealplanner.adapter.driving.neo4j.DomainToEntityMapper;
import de.urr4.mealplanner.adapter.driving.neo4j.ingredient.IngredientDomainToEntityMapper;
import de.urr4.mealplanner.adapter.driving.neo4j.meal.MealDomainToEntityMapper;
import de.urr4.mealplanner.domain.user.User;

import java.util.stream.Collectors;

public class UserDomainToEntityMapper implements DomainToEntityMapper<User, UserEntity> {

    private static UserDomainToEntityMapper instance;

    public static UserDomainToEntityMapper getInstance() {
        if (instance == null) {
            instance = new UserDomainToEntityMapper();
        }
        return instance;
    }

    private UserDomainToEntityMapper() {
    }

    @Override
    public UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setDislikedIngredients(user.getDislikedIngredients().stream().map(IngredientDomainToEntityMapper.getInstance()::toEntity).collect(Collectors.toList()));
        entity.setLikedMeals(user.getFavoriteMeals().stream().map(MealDomainToEntityMapper.getInstance()::toEntity).collect(Collectors.toList()));
        return entity;
    }

    @Override
    public User toDomain(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setName(userEntity.getName());
        user.setDislikedIngredients(userEntity.getDislikedIngredients().stream().map(IngredientDomainToEntityMapper.getInstance()::toDomain).collect(Collectors.toList()));
        user.setFavoriteMeals(userEntity.getLikedMeals().stream().map(MealDomainToEntityMapper.getInstance()::toDomain).collect(Collectors.toList()));
        return user;
    }
}
