package de.urr4.mealplanner.application.recipe;

import de.urr4.mealplanner.domain.recipe.Recipe;
import de.urr4.mealplanner.domain.recipe.RecipeRepository;
import de.urr4.mealplanner.domain.recipe.RecipeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Page<Recipe> getRecipesByPage(Pageable pageable) {
        return recipeRepository.getRecipesByPage(pageable);
    }
}
