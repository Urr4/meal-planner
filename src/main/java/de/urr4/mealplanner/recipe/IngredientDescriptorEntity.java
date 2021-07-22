package de.urr4.mealplanner.recipe;

import de.urr4.mealplanner.ingredients.IngredientEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ingredient_descriptor")
public class IngredientDescriptorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Unit unit;
    private Double amount;

    @ManyToOne
    private IngredientEntity ingredientEntity;

}
