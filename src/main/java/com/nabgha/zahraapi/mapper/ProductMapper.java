package com.nabgha.zahraapi.mapper;

import com.nabgha.zahraapi.dto.response.ProductDto;
import com.nabgha.zahraapi.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.name", target = "categoryName")
    ProductDto toDto(Product product);
}
