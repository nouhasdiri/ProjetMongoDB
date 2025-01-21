package com.example.miniProjetMongoDB.controller;

import org.springframework.ui.Model;
import com.example.miniProjetMongoDB.model.User;
import com.example.miniProjetMongoDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.findAll(); // Récupérer tous les utilisateurs
        model.addAttribute("users", users); // Ajouter la liste des utilisateurs au modèle
        return "userList"; // Nom de la vue à retourner (sans extension)
    }

    @GetMapping("/register")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute("user") User user) {
        String login = user.getPrenom().toLowerCase() + user.getNom().toLowerCase();
        user.setLogin(login);
        userService.addUser(user);
        return "redirect:/users";
    }
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Retourne le fichier login.html pour le formulaire de connexion
    }

    // Redirection après la connexion réussie
    @GetMapping("/loginSuccess")
    public String loginSuccess() {
        return "redirect:/users"; // Redirige vers /users en cas de connexion réussie
    }

    // Redirection en cas d'échec de connexion
    @GetMapping("/loginFailure")
    public String loginFailure(Model model) {
        model.addAttribute("error", "Invalid username or password");
        return "login"; // Reste sur la page de connexion avec un message d'erreur
    }

}