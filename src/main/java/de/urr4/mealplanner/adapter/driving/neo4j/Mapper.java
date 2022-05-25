package de.urr4.mealplanner.adapter.driving.neo4j;

public interface Mapper<DOMAIN, ENTITY> {

    ENTITY toEntity(DOMAIN domain);

    DOMAIN toDomain(ENTITY entity);
}
