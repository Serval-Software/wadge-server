package com.wadge.server.food;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class FoodController {

    private FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/foods")
    public List<Food> getAllFood() {
        return foodService.getAllFood();
    }

    @PostMapping("/foods")
    public void createFood(@RequestBody Food food) {
        foodService.createFood(food);
    }

    @PutMapping("/foods")
    public Food saveFood(@RequestBody Food food) {
        return foodService.updateFood(food);
    }

    @DeleteMapping("/food/{id}")
    public void deleteFood(@PathVariable long id) {
        foodService.deleteFood(id);
    }
}
