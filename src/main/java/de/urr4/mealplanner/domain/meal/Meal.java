package de.urr4.mealplanner.domain.meal;

import de.urr4.mealplanner.domain.recipe.Recipe;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Data
@Builder
public class Meal {

    private UUID id;
    private String name;
    private Collection<Recipe> recipes = new ArrayList<>();
}

