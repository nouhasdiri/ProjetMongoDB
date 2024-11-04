package com.example.miniProjetMongoDB.repository;


import com.example.miniProjetMongoDB.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {
}
