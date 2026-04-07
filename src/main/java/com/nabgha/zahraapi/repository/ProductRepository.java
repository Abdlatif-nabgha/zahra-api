package com.nabgha.zahraapi.repository;

import com.nabgha.zahraapi.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    // We only need to fetch product that are not deleted
    Page<Product> findAllByIsDeletedFalse(Pageable pageable);

    // We need this for category sidebar filter
    List<Product> findByCategoryIdAndIsDeletedFalse(Long categoryId);

    Page<Product> findByCategoryIdAndIsDeletedFalse (Long categoryId, Sort sort,
                                                     Pageable pageable);
}
