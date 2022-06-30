package de.urr4.mealplanner.adapter.driving.neo4j.user;

import de.urr4.mealplanner.application.user.UserRepository;
import de.urr4.mealplanner.domain.user.User;
import org.springframework.stereotype.Service;

@Service
public class Neo4jUserRepositoryImpl implements UserRepository {

    private final SpringDataNeo4jUserRepository userRepository;

    public Neo4jUserRepositoryImpl(SpringDataNeo4jUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return UserDomainToEntityMapper.getInstance().toDomain(userRepository.save(UserDomainToEntityMapper.getInstance().toEntity(user)));
    }

    @Override
    public User updateUser(User user) {
        return UserDomainToEntityMapper.getInstance().toDomain(userRepository.save(UserDomainToEntityMapper.getInstance().toEntity(user)));
    }
}
