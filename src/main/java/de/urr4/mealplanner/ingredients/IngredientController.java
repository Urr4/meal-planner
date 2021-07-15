package de.urr4.mealplanner.ingredients;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<IngredientDTO> getIngredients() {
        return ingredientService.getAllIngredients()
                .stream()
                .map(IngredientDTO::from)
                .collect(Collectors.toList());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody IngredientDTO createIngredient(@RequestParam("name") String name) {
        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setName(name);
        return IngredientDTO.from(ingredientService.createIngredient(ingredientEntity));
    }

}
