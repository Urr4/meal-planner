package de.urr4.mealplanner.ingredients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Transactional
    public IngredientEntity createIngredient(IngredientEntity ingredientEntity) {
        return ingredientRepository.save(ingredientEntity);
    }

    public List<IngredientEntity> getAllIngredients() {
        return ingredientRepository.findAll();
    }
}
