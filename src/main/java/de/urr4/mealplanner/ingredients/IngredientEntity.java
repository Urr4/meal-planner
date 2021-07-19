package de.urr4.mealplanner.ingredients;

import lombok.Data;

@Data
//@Entity
//@Table(name = "ingredient")
public class IngredientEntity {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
