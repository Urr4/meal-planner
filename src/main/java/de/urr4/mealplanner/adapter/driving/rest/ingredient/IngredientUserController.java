package de.urr4.mealplanner.adapter.driving.rest.ingredient;

import de.urr4.mealplanner.domain.ingredient.IngredientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/ingredients")
public class IngredientUserController {

    private final Logger LOG = LoggerFactory.getLogger(IngredientUserController.class);

    private final IngredientService ingredientService;

    public IngredientUserController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public Page<IngredientDto> getIngredientsByPage(@RequestParam(value = "page", defaultValue = "0") int pageNumber, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        LOG.info("Getting recipes for page {} with pageSize {}", pageNumber, pageSize);
        return ingredientService.getIngredientsPage(pageNumber, pageSize).map(IngredientMapper::toDto);
    }

    @GetMapping(path = "/{ingredientId}")
    public IngredientDto getIngredient(@PathVariable("ingredientId") UUID ingredientId) {
        LOG.info("Getting ingredient with ingredientId {}", ingredientId);
        return new IngredientDto(); //TODO implement
    }

    @PostMapping
    public IngredientDto createIngredient(@RequestBody CreateIngredientRequest createIngredientRequest) {
        LOG.info("Creating ingredient with name {}", createIngredientRequest.getName());
        return new IngredientDto(); //TODO implement
    }

    @PutMapping
    public void likeIngredient(@RequestBody LikeIngredientRequest likeIngredientRequest) {
        LOG.info("User {} likes ingredient with ingredientId {}", likeIngredientRequest.getUserId(), likeIngredientRequest.getIngredientId());
        //TODO implement
    }

}
