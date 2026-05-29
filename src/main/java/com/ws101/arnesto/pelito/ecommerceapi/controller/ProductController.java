package com.ws101.arnesto.pelito.ecommerceapi.controller;

import com.ws101.arnesto.pelito.ecommerceapi.entity.Product;
import com.ws101.arnesto.pelito.ecommerceapi.repository.ProductRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(
            ProductRepository productRepository
    ) {

        this.productRepository = productRepository;
    }

    // GET ALL PRODUCTS
    @GetMapping
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    // GET PRODUCT BY ID
    @GetMapping("/{id}")
    public Product getProductById(
            @PathVariable Long id
    ) {

        return productRepository.findById(id)
                .orElseThrow();
    }

    // CREATE PRODUCT
    @PostMapping
    public Product createProduct(
            @RequestBody Product product
    ) {

        return productRepository.save(product);
    }

    // UPDATE PRODUCT
    @PutMapping("/{id}")
    public Product updateProduct(
            @PathVariable Long id,
            @RequestBody Product updatedProduct
    ) {

        Product product =
                productRepository.findById(id)
                        .orElseThrow();

        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        product.setStock(updatedProduct.getStock());
        product.setImageUrl(updatedProduct.getImageUrl());

        return productRepository.save(product);
    }

    // DELETE PRODUCT
    @DeleteMapping("/{id}")
    public String deleteProduct(
            @PathVariable Long id
    ) {

        productRepository.deleteById(id);

        return "Product deleted successfully";
    }
}