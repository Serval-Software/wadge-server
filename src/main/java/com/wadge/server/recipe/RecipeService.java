package com.wadge.server.recipe;

import java.util.List;
import java.util.Optional;

import com.wadge.server.utils.db.SequenceGenerator;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RecipeService {

    private final MongoTemplate mongoTemplate;
    private final RecipeRepository recipeRepository;
    private final SequenceGenerator sequenceGenerator;

    public List<Recipe> getAllRecipe() {
        return mongoTemplate.findAll(Recipe.class);
    }

    public void createRecipe(@RequestBody Recipe recipe) {
        recipe.setId(sequenceGenerator.generateSequence("recipe_sequence"));
        recipeRepository.insert(recipe);
    }

    public Recipe updateRecipe(@RequestBody Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if(recipe.isPresent()) {
            recipeRepository.delete(recipe.get());
        }
    }
}
