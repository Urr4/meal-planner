package de.urr4.mealplanner.adapter.driving.neo4j.user;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataNeo4jUserRepository extends Neo4jRepository<UserEntity, UUID> {
}