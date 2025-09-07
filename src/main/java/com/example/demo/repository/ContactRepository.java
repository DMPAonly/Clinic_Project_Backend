package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.models.contact;

public interface ContactRepository extends MongoRepository<contact, String>{
    
}
