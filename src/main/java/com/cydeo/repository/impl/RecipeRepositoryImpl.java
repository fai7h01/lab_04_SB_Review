package com.cydeo.repository.impl;

import com.cydeo.model.Recipe;
import com.cydeo.repository.RecipeRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeRepositoryImpl implements RecipeRepository {

    // we need to create one list of recipe to keep all changes
    // and save method will add recipe to that list

    List<Recipe> recipeList = new ArrayList<>();

    @Override
    public boolean saveRecipe(Recipe recipe) {
        return recipeList.add(recipe);
    }
}
