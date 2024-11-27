package com.fullstack.foodcatalog.dto;

import com.fullstack.foodcatalog.repo.FoodItemRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCatalogPage {

    List<FoodItemDTO> foodItemList;
    Restaurant restaurant;

}
