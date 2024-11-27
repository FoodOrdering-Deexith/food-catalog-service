package com.fullstack.foodcatalog.dto;

import com.fullstack.foodcatalog.entity.FoodItem;
import com.fullstack.foodcatalog.entity.FoodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDTO {

    private UUID uuid;
    private String name;
    private String description;
    private double price;
    private UUID restaurantId;
    private String type;
    private Integer quantity;
}
