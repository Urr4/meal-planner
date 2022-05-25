package de.urr4.mealplanner.domain.tag;

import lombok.Data;

import java.util.UUID;

@Data
public class Tag {
    private UUID id;
    private String tag;
}
