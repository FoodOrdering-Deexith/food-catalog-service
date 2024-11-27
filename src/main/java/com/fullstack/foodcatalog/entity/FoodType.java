package com.fullstack.foodcatalog.entity;

public enum FoodType {
    VEGETARIAN("Veg"),
    NON_VEGETARIAN("Non-Veg"),
    VEGAN("Vegan"),
    PESCATARIAN("Pescatarian"),
    GLUTEN_FREE("Gluten-Free"),
    HALAL("Halal"),
    KOSHER("Kosher"),
    PALEO("Paleo"),
    LOW_CARB("Low-Carb"),
    DIABETIC("Diabetic");

    private final String displayName;

    FoodType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
