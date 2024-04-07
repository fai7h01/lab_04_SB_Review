package com.cydeo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("author")
public class RecipeCreatorConfig {

   // @Value("${author.firstName}")
    String firstName;
   // @Value("${author.lastName}")
    String lastName;

}
