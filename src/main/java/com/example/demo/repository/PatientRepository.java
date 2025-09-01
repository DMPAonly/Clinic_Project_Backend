package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.models.patient;

public interface PatientRepository extends MongoRepository<patient, String>{
    
}
