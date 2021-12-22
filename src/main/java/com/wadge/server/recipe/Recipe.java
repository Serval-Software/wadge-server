package com.wadge.server.recipe;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Jacksonized
@Builder
@Document
public class Recipe {
	private @Id Long id;
	private String name;
	private int servings;
	private int preparationTime;
	private int cookingTime;
	private int restTime;
	private List<RecipeIngredient> ingredients;
	private List<String> steps;
	private String difficulty;
	private List<String> tools;
	private List<String> tags;

	// TODO -> create builder
	public Recipe(String name, int servings, int preparationTime, int cookingTime, int restTime,
		List<RecipeIngredient> ingredients, List<String> steps, String difficulty, 
		List<String> tools, List<String> tags) {
			
		this.name = name;
		this.servings = servings;
		this.preparationTime = preparationTime;
		this.cookingTime = cookingTime;
		this.restTime = restTime;
		this.ingredients = ingredients;
		this.steps = steps;
		this.difficulty = difficulty;
		this.tools = tools;
		this.tags = tags;
	}


}
