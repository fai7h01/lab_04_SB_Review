package com.cydeo;

import com.cydeo.config.RecipeCreatorConfig;
import com.cydeo.service.RecipeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Lab04SbReviewApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Lab04SbReviewApplication.class, args);

        RecipeService recipeService = context.getBean(RecipeService.class);
        recipeService.prepareRecipe();

        RecipeCreatorConfig creatorConfig = context.getBean(RecipeCreatorConfig.class);
        System.out.println(creatorConfig.getFirstName());
        System.out.println(creatorConfig.getLastName());

    }

}
