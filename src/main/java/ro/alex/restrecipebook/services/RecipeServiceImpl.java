package ro.alex.restrecipebook.services;

import org.springframework.stereotype.Service;
import ro.alex.restrecipebook.models.Recipe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
@Service
public class RecipeServiceImpl implements RecipeService{

    private List<Recipe> recipeList = new ArrayList<>();
    @Override
    public Recipe createRecipe(Recipe recipe) {
        recipe.setId(UUID.randomUUID());
        recipeList.add(recipe);
        return recipe;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeList;
    }

    @Override
    public List<Recipe> searchRecipe(List<String> ingredients, String dishType) {
        List<Recipe> recipes = new ArrayList<>();
        for(Recipe recipe : recipeList){
            List<String> currentIngredients = recipe.getIngredients()
                    .stream()
                    .map(String::toLowerCase)
                    .toList();
            List<String> searchIngredients = ingredients.stream()
                    .map(String::toLowerCase)
                    .toList();
            if(recipe.getDishType().equalsIgnoreCase(dishType) && new HashSet<>(currentIngredients)
                    .containsAll(searchIngredients)){
                recipes.add(recipe);
            }
        }
        return recipes;
    }
}
