package com.example.miniProjetMongoDB.service;

import com.example.miniProjetMongoDB.model.User;
import com.example.miniProjetMongoDB.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    public List<User> findAll() {
        return userRepo.findAll();
    }
    public User findByLogin(String login) {
        return userRepo.findById(login).orElse(null);
    }
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
    public void deleteUser(User user) {
        userRepo.delete(user);
    }

    public void addFriend(String login, String friendLogin) {
        User user = findByLogin(login);
        User friend = findByLogin(friendLogin);
        if (user != null && friend != null) {
            user.getAmis().add(friend); // Assurez-vous que friends est une liste dans la classe User
            userRepo.save(user);
        }
    }

    public void removeFriend(String login, String friendLogin) {
        User user = findByLogin(login);
        User freind = findByLogin(friendLogin);
        if (user != null) {
            user.getAmis().remove(freind); // Suppression de l'ami
            userRepo.save(user);
        }
    }

}