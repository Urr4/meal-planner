package de.urr4.mealplanner.test;

import de.urr4.mealplanner.domain.meal.Meal;
import de.urr4.mealplanner.domain.recipe.IngredientDescriptor;
import de.urr4.mealplanner.domain.recipe.Recipe;
import de.urr4.mealplanner.domain.recipe.RecipeType;
import de.urr4.mealplanner.domain.tag.Tag;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public abstract class TestObjectFactory {

    // Forbid instancing
    private TestObjectFactory() {
    }

    public static RecipeBuilder recipe() {
        return new RecipeBuilder();
    }

    public static class RecipeBuilder {

        private UUID id = UUID.randomUUID();
        private String name = "Test Recipe";
        private RecipeType recipeType = RecipeType.MAIN;
        private String instructions = "Do stuff";
        private Collection<IngredientDescriptor> ingredientDescriptors = new ArrayList<>();
        private Collection<Tag> tags = new ArrayList<>();

        public RecipeBuilder withId(UUID id){
            this.id = id;
            return this;
        }

        public RecipeBuilder withRecipeType(RecipeType recipeType){
            this.recipeType = recipeType;
            return this;
        }

        public Recipe build() {
            Recipe recipe = new Recipe();
            recipe.setId(id);
            recipe.setName(name);
            recipe.setRecipeType(recipeType);
            recipe.setInstructions(instructions);
            recipe.setIngredientDescriptors(ingredientDescriptors);
            recipe.setTags(tags);
            return recipe;
        }
    }

    public static MealBuilder meal(){
        return new MealBuilder();
    }

    public static class MealBuilder{

        private UUID id = UUID.randomUUID();
        private String name = "Test Meal";
        private Collection<Recipe> recipes = new ArrayList<>();

        public MealBuilder withId(UUID id){
            this.id = id;
            return this;
        }

        public Meal build(){
            return Meal.builder()
                    .id(id)
                    .name(name)
                    .recipes(recipes)
                    .build();
        }
    }


}
