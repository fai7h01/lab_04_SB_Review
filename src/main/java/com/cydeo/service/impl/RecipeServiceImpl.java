package com.cydeo.service.impl;

import com.cydeo.enums.QuantityType;
import com.cydeo.enums.RecipeType;
import com.cydeo.model.Ingredient;
import com.cydeo.model.Recipe;
import com.cydeo.repository.RecipeRepository;
import com.cydeo.service.RecipeService;
import com.cydeo.service.ShareService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final ShareService shareService;
    private final Faker faker;

    public RecipeServiceImpl(RecipeRepository recipeRepository,@Qualifier("INSTAGRAM") ShareService shareService, Faker faker) {
        this.recipeRepository = recipeRepository;
        this.shareService = shareService;
        this.faker = faker;
    }

    @Override
    public boolean prepareRecipe() {
        //create a recipe object
        Recipe recipe = new Recipe();

        //set fields
        recipe.setId(UUID.randomUUID());
        recipe.setName(faker.food().dish());
        recipe.setDuration(generateRandomValue());
        recipe.setPreparation(faker.lorem().paragraph(5));
        recipe.setRecipeType(RecipeType.BREAKFAST);
        recipe.setIngredients(prepareIngredients());

        //save the recipe
        recipeRepository.saveRecipe(recipe);

        //share recipe
        shareService.shareRecipe(recipe);

        //return true
        return true;
    }

    private List<Ingredient> prepareIngredients(){
        List<Ingredient> ingredients = new ArrayList<>();
        for (int i = 0; i < generateRandomValue(); i++) {
            Ingredient ingredient = new Ingredient();

            ingredient.setName(faker.food().ingredient());
            ingredient.setQuantity(generateRandomValue());
            ingredient.setQuantityType(QuantityType.LB);

            ingredients.add(ingredient);
        }
        return ingredients;
    }

    private int generateRandomValue(){
        return new Random().nextInt(20) + 1;
    }
}
