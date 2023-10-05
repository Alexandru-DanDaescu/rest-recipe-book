package ro.alex.restrecipebook.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.alex.restrecipebook.models.Recipe;
import ro.alex.restrecipebook.services.RecipeService;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping()
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe){
        return ResponseEntity.ok(recipeService.createRecipe(recipe));
    }

    @GetMapping()
    public ResponseEntity<List<Recipe>> getAllRecipes(){
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    @GetMapping("/{ingredients}/{dishType}")
    public ResponseEntity<List<Recipe>> searchRecipe(@PathVariable List<String> ingredients, @PathVariable String dishType){
        return ResponseEntity.ok(recipeService.searchRecipe(ingredients, dishType));
    }



}
