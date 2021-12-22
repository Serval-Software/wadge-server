package com.wadge.server.recipe;

import com.wadge.server.utils.db.JsonReader;
import com.wadge.server.utils.db.SequenceGenerator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class RecipeConfig {
    private SequenceGenerator sequenceGenerator;
    @Bean
    CommandLineRunner recipeCommandLineRunner(final RecipeRepository recipeRepository) {
        return args -> {
            if(recipeRepository.findAll().isEmpty()) {
                recipeRepository.saveAll( 
                    new JsonReader().readFile("src/main/resources/recipes.json", Recipe.class)
                    .stream()
                    .map(recipe -> {
						recipe.setId(sequenceGenerator.generateSequence("recipe_sequence"));
						return recipe;
					}).toList()
				);
            }
        };
    }
}
