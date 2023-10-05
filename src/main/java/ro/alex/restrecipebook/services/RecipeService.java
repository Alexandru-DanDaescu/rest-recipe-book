package ro.alex.restrecipebook.services;


import ro.alex.restrecipebook.models.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe createRecipe(Recipe recipe);

    List<Recipe> getAllRecipes();

    List<Recipe> searchRecipe(List<String> ingredients, String dishType);


}
