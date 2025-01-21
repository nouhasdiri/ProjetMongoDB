package com.example.miniProjetMongoDB.service;

import com.example.miniProjetMongoDB.model.User;
import com.example.miniProjetMongoDB.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> authUser = userRepo.findByLogin(login.toLowerCase());
        if (!authUser.isPresent()) {
            System.out.println("User not found: " + login); // Log si l'utilisateur n'est pas trouvé
            throw new UsernameNotFoundException(login);
        } else {
            System.out.println("User found: " + authUser.get().getLogin()); // Log de l'utilisateur trouvé
            return new CustomUserDetails(authUser.get());
        }
    }


}
