package com.nabgha.zahraapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false) // Added constraint
    private Integer quantity;

    @Column(name = "image_url")
    private String imageUrl;

    // Removed cascade, kept LAZY
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

    // FIXED: Changed from @JoinColumn to @Column
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}