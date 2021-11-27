package com.wadge.server.food;

import java.util.List;
import java.util.Optional;

import com.wadge.server.utils.db.SequenceGenerator;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FoodService {

    private final MongoTemplate mongoTemplate;
    private final FoodRepository foodRepository;
    private final SequenceGenerator sequenceGenerator;

    public List<Food> getAllFood() {
        return mongoTemplate.findAll(Food.class);
    }

    public void createFood(@RequestBody Food food) {
        food.setId(sequenceGenerator.generateSequence("food_sequence"));
        foodRepository.insert(food);
    }

    public Food updateFood(@RequestBody Food food) {
        return foodRepository.save(food);
    }

    public void deleteFood(Long id) {
        Optional<Food> food = foodRepository.findById(id);
        if(food.isPresent()) {
            foodRepository.delete(food.get());
        }
    }
}
