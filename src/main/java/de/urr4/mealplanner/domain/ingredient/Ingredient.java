package de.urr4.mealplanner.domain.ingredient;

import de.urr4.mealplanner.domain.tag.Tag;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Data
public class Ingredient {

    private UUID id;
    private String name;
    private Collection<Tag> tags = new ArrayList<>();

}
