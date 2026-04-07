package com.nabgha.zahraapi.dto.response;

import java.math.BigDecimal;



public record ProductDto(
        Long id,
        String name,
        String description,
        BigDecimal price,
        Integer quantity,
        String imageUrl,
        String categoryName
)
{}
