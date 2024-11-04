package com.example.miniProjetMongoDB.service;

import com.example.miniProjetMongoDB.model.User;
import com.example.miniProjetMongoDB.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public List<User> findAll() {
        return userRepo.findAll();
    }
    public User findByLogin(String login) {
        return userRepo.findById(login).get();
    }
    public User save(User user) {
        return userRepo.save(user);
    }
    public void delete(User user) {
        userRepo.delete(user);
    }

}
