package de.urr4.mealplanner.ingredients.rest;

import de.urr4.mealplanner.ingredients.IngredientEntity;
import de.urr4.mealplanner.ingredients.IngredientService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
        return ingredientService.getAllIngredients()
                .stream()
                .map(IngredientDTO::from)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Returns Ingredient by id")
    @GetMapping(path = "/{ingredientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public IngredientDTO getIngredientById(@PathVariable("ingredientId") Long ingedientId) {
        return IngredientDTO.from(ingredientService.getIngredientById(ingedientId));
    }

    @Transactional
    @Operation(summary = "Create a new Ingredient")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    IngredientDTO createIngredient(@RequestBody @Valid CreateIngredientRequest createIngredientRequest) {
        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setName(createIngredientRequest.getName());
        return IngredientDTO.from(ingredientService.saveIngredient(ingredientEntity));
    }

    @Transactional
    @Operation(summary = "Deletes an Ingredient")
    @DeleteMapping(path = "/{ingredientId}")
    public void deleteIngredient(@PathVariable("ingredientId") Long ingredientId) {
        IngredientEntity ingredientEntity = ingredientService.getIngredientById(ingredientId);
        ingredientService.deleteIngredient(ingredientEntity);
    }

    @Transactional
    @Operation(summary = "Updates an Ingredient")
    @PutMapping
    public IngredientDTO updateIngredient(@RequestBody @Valid UpdateIngredientRequest updateIngredientRequest) {
        IngredientEntity ingredientEntity = ingredientService.getIngredientById(updateIngredientRequest.getId());
        ingredientEntity.setName(updateIngredientRequest.getName());
        return IngredientDTO.from(ingredientService.saveIngredient(ingredientEntity));
    }

}
