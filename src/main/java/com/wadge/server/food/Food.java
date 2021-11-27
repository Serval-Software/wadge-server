package com.wadge.server.food;

import java.time.Month;
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
public class Food {
    private @Id Long id;
    private String name;
    private FoodType type;
    private List<Month> availability;
    private int expiration;

    public Food(String name, FoodType type, List<Month> availability, int expiration) {
        this.name = name;
        this.type = type;
        this.availability = availability;
        this.expiration = expiration;
    }
}
