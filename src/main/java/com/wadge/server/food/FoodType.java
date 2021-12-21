package com.wadge.server.food;

public enum FoodType {
    FRUIT, VEGETABLE;

    // TODO -> improve
    public static FoodType fromString(final String value) {
        return switch(value) {
            case "fruit" -> FRUIT;
            case "legume" -> VEGETABLE;
            default -> VEGETABLE;
        };
    }
}
