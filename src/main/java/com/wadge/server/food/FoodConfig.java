package com.wadge.server.food;

import java.time.Month;
import java.util.List;

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
    CommandLineRunner commandLineRunner(FoodRepository foodRepository) {
        return args -> foodRepository.save(new Food(sequenceGenerator.generateSequence("food_sequence"), 
			"Apple", 
			FoodType.FRUIT, 
			List.of(Month.JUNE), 
			2));
    }
}
