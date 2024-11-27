package com.fullstack.foodcatalog.service;

import com.fullstack.foodcatalog.dto.FoodCatalogPage;
import com.fullstack.foodcatalog.dto.FoodItemDTO;
import com.fullstack.foodcatalog.dto.Restaurant;
import com.fullstack.foodcatalog.entity.FoodItem;
import com.fullstack.foodcatalog.mapper.FoodItemMapper;
import com.fullstack.foodcatalog.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FoodCatalogService {

    @Autowired
    FoodItemRepo foodItemRepo;

    @Autowired
    RestTemplate restTemplate;

    @Value("${service.url.restaurant}")
    private String restaurantUrl;



    public FoodCatalogPage getAllFoodsForGivenRestaurant(UUID restaurantId) {
        List<FoodItem> foods = foodItemRepo.findByRestaurantId(restaurantId);
        List<FoodItemDTO> foodItemDTOS = foods.stream().map(FoodItemMapper.INSTANCE::mapFoodItemToFoodItemDTO).collect(Collectors.toList());
        Restaurant restaurant = getRestaurantDetails(restaurantId);
        FoodCatalogPage foodCatalogPage = new FoodCatalogPage(foodItemDTOS, restaurant);
        return foodCatalogPage;
    }

    private Restaurant getRestaurantDetails(UUID restaurantId) {
        URI getRestaurantUrl = URI.create(restaurantUrl).resolve("/v1/restaurant/" + restaurantId);
        return this.restTemplate.getForObject(getRestaurantUrl, Restaurant.class);
    }

    public UUID addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem savedFoodItem = foodItemRepo.saveAndFlush(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
        return savedFoodItem.getUuid();
    }
}
