package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.models.orders;

public interface OrdersRepository extends MongoRepository<orders, String> {
    
}
