package com.wadge.server.recipe;

import com.wadge.server.food.Unit;

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
public class RecipeIngredient {
	private String name;
	private Unit unit;
	private int quantity;
	
}
