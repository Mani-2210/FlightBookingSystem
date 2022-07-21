package com.userdetails.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.userdetails.model.UserDetails;

public interface UserRepository extends MongoRepository<UserDetails, String> {
  UserDetails findByEmail(String email);
}
