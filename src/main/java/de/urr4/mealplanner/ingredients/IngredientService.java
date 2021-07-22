package de.urr4.mealplanner.ingredients;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public IngredientEntity saveIngredient(IngredientEntity ingredientEntity) {
        return ingredientRepository.save(ingredientEntity);
    }

    public List<IngredientEntity> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public IngredientEntity getIngredientById(Long ingredientId) {
        return ingredientRepository.getById(ingredientId);
    }

    public void deleteIngredient(IngredientEntity ingredientEntity) {
        ingredientRepository.delete(ingredientEntity);
    }
}
