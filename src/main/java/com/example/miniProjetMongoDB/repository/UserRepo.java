package com.example.miniProjetMongoDB.repository;


import com.example.miniProjetMongoDB.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
    Optional<User> findByLogin(String Login);
}
