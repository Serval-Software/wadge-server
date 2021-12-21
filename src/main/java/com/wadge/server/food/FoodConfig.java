package com.wadge.server.food;

import com.wadge.server.utils.common.MonthMapper;
import com.wadge.server.utils.db.JsonReader;
import com.wadge.server.utils.db.SequenceGenerator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class FoodConfig {
    private SequenceGenerator sequenceGenerator;
    @Bean
    CommandLineRunner commandLineRunner(final FoodRepository foodRepository) {
        final MonthMapper mapper = new MonthMapper();

        return args -> {
            if(foodRepository.findAll().isEmpty()) {
                foodRepository.saveAll( 
                    new JsonReader().readFile("src/main/resources/food.json", LoadedFood.class)
                    .stream()
                    .map(food -> food.toFood(
                        sequenceGenerator.generateSequence("food_sequence"), 
                        mapper))
                    .toList()
                    );
            }
        };
    }
}
