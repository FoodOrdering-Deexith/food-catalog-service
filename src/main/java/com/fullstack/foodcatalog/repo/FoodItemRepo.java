package com.fullstack.foodcatalog.repo;

import com.fullstack.foodcatalog.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem, UUID> {
    List<FoodItem> findByRestaurantId(UUID restaurantId);
}
