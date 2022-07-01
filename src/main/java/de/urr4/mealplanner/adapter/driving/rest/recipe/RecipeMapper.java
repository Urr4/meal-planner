package de.urr4.mealplanner.adapter.driving.rest.recipe;

import de.urr4.mealplanner.adapter.driving.rest.DomainToDtoMapper;
import de.urr4.mealplanner.adapter.driving.rest.tag.TagMapper;
import de.urr4.mealplanner.domain.recipe.Recipe;

import java.util.stream.Collectors;

public class RecipeMapper implements DomainToDtoMapper<RecipeDto, Recipe> {

    private static RecipeMapper instance;

    public static RecipeMapper getInstance() {
        if (instance == null) {
            instance = new RecipeMapper();
        }
        return instance;
    }

    private RecipeMapper() {
    }

    public RecipeDto toDto(Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(recipe.getId());
        recipeDto.setName(recipe.getName());
        recipeDto.setRecipeType(recipe.getRecipeType());
        recipeDto.setInstructions(recipe.getInstructions());
        recipeDto.setIngredientDescriptors(recipe.getIngredientDescriptors().stream().map(IngredientDescriptorMapper::toDto).collect(Collectors.toList()));
        recipeDto.setTags(recipe.getTags().stream().map(TagMapper.getInstance()::toDto).collect(Collectors.toList()));
        return recipeDto;
    }

    public Recipe toDomain(RecipeDto recipeDto) {
        Recipe recipe = new Recipe();
        recipe.setId(recipeDto.getId());
        recipe.setName(recipeDto.getName());
        recipe.setRecipeType(recipeDto.getRecipeType());
        recipe.setInstructions(recipeDto.getInstructions());
        recipe.setIngredientDescriptors(recipeDto.getIngredientDescriptors().stream().map(IngredientDescriptorMapper::toDomain).collect(Collectors.toList()));
        recipe.setTags(recipeDto.getTags().stream().map(TagMapper.getInstance()::toDomain).collect(Collectors.toList()));
        return recipe;
    }

}
