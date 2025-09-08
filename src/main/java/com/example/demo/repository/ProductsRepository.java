package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.models.products;

public interface ProductsRepository extends MongoRepository<products, String> {
    
}
