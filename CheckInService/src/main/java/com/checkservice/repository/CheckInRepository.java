package com.checkservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.checkservice.model.ModelClass;

public interface CheckInRepository extends MongoRepository<ModelClass, String> {

}
