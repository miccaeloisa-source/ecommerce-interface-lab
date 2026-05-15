package com.ws101.Arnesto.Pelito.EcommerceApi.model; // Fix 1: Full package path

import lombok.*;

/**
 * Product entity representing an e-commerce item.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product { // Fix 2: Remove the ".java" from the class name
    private Long id;
    private String name;
    private String description;
    private double price;
    private String category;
    private int stockQuantity;
    private String imageUrl;
}