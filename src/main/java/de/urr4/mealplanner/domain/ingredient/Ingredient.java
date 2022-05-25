package de.urr4.mealplanner.domain.ingredient;

import lombok.Data;

import java.util.UUID;

@Data
public class Ingredient {

    private UUID id;
    private String name;

}
