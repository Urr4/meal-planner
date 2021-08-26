package de.urr4.mealplanner.descriptor;

import org.springframework.stereotype.Service;

@Service
public class IngredientDescriptorService {

    private final IngredientDescriptorRepository ingredientDescriptorRepository;

    public IngredientDescriptorService(IngredientDescriptorRepository ingredientDescriptorRepository){
        this.ingredientDescriptorRepository = ingredientDescriptorRepository;
    }

    public IngredientDescriptorEntity getIngredientDescriptorEntityById(Long id){
        return ingredientDescriptorRepository.getById(id);
    }
}
