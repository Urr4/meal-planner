package de.urr4.mealplanner.descriptor.rest;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import de.urr4.mealplanner.ingredients.rest.IngredientDTO;
import de.urr4.mealplanner.recipe.Unit;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@ToString
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CreateIngredientDescriptorRequest.class, name = "create"),
        @JsonSubTypes.Type(value = UpdateIngredientDescritorRequest.class, name = "update")
})
public abstract class IngredientDescriptorRequest {

    @NotNull
    private Unit unit;

    @NotNull
    private Double amount;

    @NotNull
    private Long ingredientId;

    private String type;
}
