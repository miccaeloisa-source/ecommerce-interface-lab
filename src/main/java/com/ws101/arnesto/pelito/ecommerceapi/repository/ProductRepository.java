package com.ws101.arnesto.pelito.ecommerceapi.repository;

import com.ws101.arnesto.pelito.ecommerceapi.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, Long> {

}