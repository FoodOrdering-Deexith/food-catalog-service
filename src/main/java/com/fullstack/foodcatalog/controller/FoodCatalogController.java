package com.fullstack.foodcatalog.controller;

import com.fullstack.foodcatalog.dto.FoodCatalogPage;
import com.fullstack.foodcatalog.dto.FoodItemDTO;
import com.fullstack.foodcatalog.service.FoodCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("v1/food-catalog")
public class FoodCatalogController {

    @Autowired
    FoodCatalogService foodCatalogService;

    @GetMapping("/{restaurantId}/foods")
    public ResponseEntity<FoodCatalogPage> getAllFoodForGivenRestaurant(@PathVariable UUID restaurantId) {
        return new ResponseEntity<>(foodCatalogService.getAllFoodsForGivenRestaurant(restaurantId), HttpStatus.OK);
    }

    @PostMapping("/food")
    public ResponseEntity<?> addFoodItem(@RequestBody FoodItemDTO foodItemDTO) {
        Map<String, UUID> response = new HashMap<>();
        response.put("id", foodCatalogService.addFoodItem(foodItemDTO));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
