package ro.alex.restrecipebook.models;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Recipe {

    private UUID id;

    private String title;

    private List<String> ingredients;

    private String cookingInstructions;

    private String dishType;

}
