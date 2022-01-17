package de.urr4.mealplanner.adapter.driving.rest.ingredient;

import de.urr4.mealplanner.domain.ingredient.IngredientService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/ingredients")
public class IngredientRestController {

    private final IngredientService ingredientService;

    public IngredientRestController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public Page<IngredientDto> getIngredientsByPage(@RequestParam(value = "page", defaultValue = "0") int pageNumber, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        return ingredientService.getIngredientsPage(pageNumber, pageSize).map(IngredientMapper::toDto);
    }

    @PostMapping
    public IngredientDto saveIngredient(@RequestBody IngredientDto ingredientDto) {
        return IngredientMapper.toDto(ingredientService.saveIngredient(IngredientMapper.toDomain(ingredientDto)));
    }
}
