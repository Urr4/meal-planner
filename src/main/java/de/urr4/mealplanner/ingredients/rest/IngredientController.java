package de.urr4.mealplanner.ingredients.rest;

import de.urr4.mealplanner.ingredients.IngredientEntity;
import de.urr4.mealplanner.ingredients.IngredientService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RestController
@RequestMapping(path = "/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Operation(summary = "Returns all Ingredients")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<IngredientDTO> getAllIngredients() {
        log.info("Getting all Ingredients");
        return ingredientService.getAllIngredients()
                .stream()
                .map(IngredientDTO::from)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Returns Ingredient by id")
    @GetMapping(path = "/{ingredientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public IngredientDTO getIngredientById(@PathVariable("ingredientId") Long ingredientId) {
        log.info("Getting Ingredient by id " + ingredientId);
        return IngredientDTO.from(ingredientService.getIngredientById(ingredientId));
    }

    @Transactional
    @Operation(summary = "Create a new Ingredient")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    IngredientDTO createIngredient(@RequestBody @Valid CreateIngredientRequest createIngredientRequest) {
        log.info("Creating Ingredient " + createIngredientRequest);
        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setName(createIngredientRequest.getName());
        return IngredientDTO.from(ingredientService.saveIngredient(ingredientEntity));
    }

    @Transactional
    @Operation(summary = "Deletes an Ingredient")
    @DeleteMapping(path = "/{ingredientId}")
    public void deleteIngredient(@PathVariable("ingredientId") Long ingredientId) {
        log.info("Deleting Ingredient " + ingredientId);
        IngredientEntity ingredientEntity = ingredientService.getIngredientById(ingredientId);
        ingredientService.deleteIngredient(ingredientEntity);
    }

    @Transactional
    @Operation(summary = "Updates an Ingredient")
    @PutMapping
    public IngredientDTO updateIngredient(@RequestBody @Valid UpdateIngredientRequest updateIngredientRequest) {
        log.info("Updating Ingredient " + updateIngredientRequest);
        IngredientEntity ingredientEntity = ingredientService.getIngredientById(updateIngredientRequest.getId());
        ingredientEntity.setName(updateIngredientRequest.getName());
        return IngredientDTO.from(ingredientService.saveIngredient(ingredientEntity));
    }

}
