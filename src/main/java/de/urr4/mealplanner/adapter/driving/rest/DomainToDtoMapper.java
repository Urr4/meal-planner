package de.urr4.mealplanner.adapter.driving.rest;

public interface DomainToDtoMapper<DTO, DOMAIN> {

    DTO toDto(DOMAIN domain);

    DOMAIN toDomain(DTO dto);
}
