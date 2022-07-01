package de.urr4.mealplanner.adapter.driving.neo4j.recipe;

import de.urr4.mealplanner.domain.recipe.RecipeType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
@Disabled("Disabled since this test uses the active DB and is only intended to be executes manually to create test-data in the DB")
class RecipeIT {

    @Autowired
    private SpringDataNeo4jRecipeRepository springDataNeo4jRecipeRepository;

    @Test
    void persistTestRecipes() {
        for (int i = 0; i < 10; i++) {

            RecipeType recipeType;
            switch (i % 5) {
                case 0:
                    recipeType = RecipeType.ONLY;
                    break;
                case 1:
                    recipeType = RecipeType.MAIN;
                    break;
                case 2:
                case 3:
                    recipeType = RecipeType.SIDE;
                    break;
                case 4:
                    recipeType = RecipeType.SAUCE;
                    break;
                default:
                    recipeType = RecipeType.ONLY;
            }

            RecipeEntity recipeEntity = new RecipeEntity();
            recipeEntity.setName(String.format("Test-Recipe %s", i));
            recipeEntity.setRecipeType(recipeType);
            recipeEntity.setInstructions("Do something magical");
            springDataNeo4jRecipeRepository.save(recipeEntity);
        }
    }
}