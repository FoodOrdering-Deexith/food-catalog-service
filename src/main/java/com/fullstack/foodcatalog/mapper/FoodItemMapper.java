package com.fullstack.foodcatalog.mapper;

import com.fullstack.foodcatalog.dto.FoodItemDTO;
import com.fullstack.foodcatalog.entity.FoodItem;
import com.fullstack.foodcatalog.entity.FoodType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    // Custom mapping for FoodItem -> FoodItemDTO
    @Mapping(source = "type", target = "type", qualifiedByName = "mapToString")
    FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);

    // Custom mapping for FoodItemDTO -> FoodItem
    @Mapping(source = "type", target = "type", qualifiedByName = "mapToEnum")
    FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);

    // Converts FoodType to String
    @Named("mapToString")
    default String mapToString(FoodType foodType) {
        return (foodType != null) ? foodType.getDisplayName() : null;
    }

    // Converts String to FoodType
    @Named("mapToEnum")
    default FoodType mapToEnum(String displayName) {
        if (displayName == null) {
            return null;
        }
        for (FoodType type : FoodType.values()) {
            if (type.getDisplayName().equalsIgnoreCase(displayName)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown FoodType display name: " + displayName);
    }
}
