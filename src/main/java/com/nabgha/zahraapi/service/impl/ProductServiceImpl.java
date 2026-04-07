package com.nabgha.zahraapi.service.impl;


import com.nabgha.zahraapi.dto.response.PageResponse;
import com.nabgha.zahraapi.dto.response.ProductDto;
import com.nabgha.zahraapi.entity.Product;
import com.nabgha.zahraapi.mapper.ProductMapper;
import com.nabgha.zahraapi.repository.ProductRepository;
import com.nabgha.zahraapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    public PageResponse<ProductDto> getAllActiveProducts(int page, int size, String sortBy, String sortDir) {
        // 1. configure sorting
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        // 2. create the Pageable object
        Pageable pageable = PageRequest.of(page, size, sort);

        // 3. fetch data from database
        Page<Product> productPage = productRepository.findAllByIsDeletedFalse(pageable);
        // 4. converts entities to Dto
        List<ProductDto> content = productPage.getContent().stream()
                .map(productMapper::toDto)
                .toList();
        // 5. wrap the DTOs and metadata into our customer response
        return new PageResponse<>(
                content,
                productPage.getNumber(),
                productPage.getSize(),
                productPage.getTotalElements(),
                productPage.getTotalPages(),
                productPage.isLast()
        );
    }

    @Override
    public ProductDto getProduct(Long id) {
        return null;
    }
}
