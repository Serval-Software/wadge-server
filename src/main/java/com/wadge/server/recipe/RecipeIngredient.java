package com.wadge.server.recipe;

import com.wadge.server.food.Unit;

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
public class RecipeIngredient {
	private String name;
	private Unit unit;
	private int quantity;
	
}
