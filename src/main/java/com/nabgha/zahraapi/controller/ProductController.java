package com.nabgha.zahraapi.controller;


import com.nabgha.zahraapi.dto.response.ApiResponse;
import com.nabgha.zahraapi.dto.response.PageResponse;
import com.nabgha.zahraapi.dto.response.ProductDto;
import com.nabgha.zahraapi.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<ProductDto>>> getProducts(
            int page,
            int size,
            String sortBy,
            String sortDir
    )
    {
        // Fetch paginated data
        PageResponse<ProductDto> productPage = productService.getAllActiveProducts(
                page,
                size,
                sortBy,
                sortDir
        );
        return ResponseEntity.ok(ApiResponse.success(productPage, "Product retrieved successfully"));
    }
}
