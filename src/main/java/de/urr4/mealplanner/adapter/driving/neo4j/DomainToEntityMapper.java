package de.urr4.mealplanner.adapter.driving.neo4j;

public interface DomainToEntityMapper<DOMAIN, ENTITY> {

    ENTITY toEntity(DOMAIN domain);

    DOMAIN toDomain(ENTITY entity);
}
