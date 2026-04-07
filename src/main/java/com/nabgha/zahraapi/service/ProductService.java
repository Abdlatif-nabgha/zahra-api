package com.nabgha.zahraapi.service;


import com.nabgha.zahraapi.dto.response.PageResponse;
import com.nabgha.zahraapi.dto.response.ProductDto;

import java.util.List;

public interface ProductService {
    PageResponse<ProductDto> getAllActiveProducts(int page, int size, String sortBy, String sortDir);
    ProductDto getProduct(Long id);
}
