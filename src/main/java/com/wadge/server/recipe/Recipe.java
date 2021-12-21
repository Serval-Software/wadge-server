package com.wadge.server.recipe;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Document
public class Recipe {
	private @Id Long id;
	private String name;
	private int servings;
	private int preparationTime;
	private int cookingTime;
	private int restTime;
	private List<RecipeIngredient> ingredients;

	public Recipe(String name, int servings, int preparationTime, int cookingTime, int restTime,
			List<RecipeIngredient> ingredients) {
		this.name = name;
		this.servings = servings;
		this.preparationTime = preparationTime;
		this.cookingTime = cookingTime;
		this.restTime = restTime;
		this.ingredients = ingredients;
	}


}
