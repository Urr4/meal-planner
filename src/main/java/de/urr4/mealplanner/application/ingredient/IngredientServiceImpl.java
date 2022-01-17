package de.urr4.mealplanner.application.ingredient;

import de.urr4.mealplanner.domain.ingredient.Ingredient;
import de.urr4.mealplanner.domain.ingredient.IngredientRepository;
import de.urr4.mealplanner.domain.ingredient.IngredientService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Page<Ingredient> getIngredientsPage(int pageNumber, int pageSize) {
        return ingredientRepository.loadIngredientsPage(pageNumber, pageSize);
    }

    @Override
    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.saveIngredient(ingredient);
    }
}
