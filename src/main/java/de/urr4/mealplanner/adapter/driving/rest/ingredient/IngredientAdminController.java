package de.urr4.mealplanner.adapter.driving.rest.ingredient;

import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ingredients/admin")
public class IngredientAdminController {

    private final Logger LOG = LoggerFactory.getLogger(IngredientAdminController.class);

    @PutMapping
    public IngredientDto updateIngredient(@RequestBody UpdateIngredientRequest updateIngredientRequest) {
        LOG.info("Updating ingredient with ingredientId {}", updateIngredientRequest.getIngredientId());
        throw new NotImplementedException(); //TODO implement
    }

    @PutMapping(path = "/join")
    public void joinIngredient(@RequestBody JoinIngredientRequest joinIngredientRequest) {
        LOG.info("Joining ingredients {} and {}", joinIngredientRequest.getOriginalIngredientId(), joinIngredientRequest.getRedundantIngredientId());
        throw new NotImplementedException(); //TODO implement
    }

}
