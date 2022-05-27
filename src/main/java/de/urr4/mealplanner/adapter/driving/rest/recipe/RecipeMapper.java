package de.urr4.mealplanner.adapter.driving.rest.recipe;

import de.urr4.mealplanner.adapter.driving.rest.tag.TagMapper;
import de.urr4.mealplanner.domain.recipe.Recipe;

import java.util.stream.Collectors;

public class RecipeMapper {

    public static RecipeDto toDto(Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(recipe.getId());
        recipeDto.setName(recipe.getName());
        recipeDto.setInstructions(recipe.getInstructions());
        recipeDto.setIngredientDescriptors(recipe.getIngredientDescriptors().stream().map(IngredientDescriptorMapper::toDto).collect(Collectors.toList()));
        recipeDto.setTags(recipe.getTags().stream().map(TagMapper::toDto).collect(Collectors.toList()));
        return recipeDto;
    }

    public static Recipe toDomain(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setId(recipeDto.getId());
        recipe.setName(recipeDto.getName());
        recipe.setInstructions(recipeDto.getInstructions());
        recipe.setIngredientDescriptors(recipeDto.getIngredientDescriptors().stream().map(IngredientDescriptorMapper::toDomain).collect(Collectors.toList()));
        recipe.setTags(recipeDto.getTags().stream().map(TagMapper::toDomain).collect(Collectors.toList()));
        return recipe;
    }

}
