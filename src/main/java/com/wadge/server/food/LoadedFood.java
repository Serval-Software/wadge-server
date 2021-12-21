package com.wadge.server.food;

import java.util.List;

import com.wadge.server.utils.common.MonthMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoadedFood {
	private String name;
    private String type;
    private List<String> availability;
    private int expiration;
    private double quantity;
    private String unit;	

	public Food toFood(final Long id, final MonthMapper mapper) {
		return new Food(
			id,
			name,
			FoodType.fromString(type),
			availability.stream().map(mapper::map).toList(),
			expiration,
			quantity,
			Unit.valueOf(unit)
		);
	}
}
