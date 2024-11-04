package com.example.miniProjetMongoDB;

import com.example.miniProjetMongoDB.model.User;
import com.example.miniProjetMongoDB.repository.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MiniProjetMongoDbApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(MiniProjetMongoDbApplication.class, args);

		// Récupération des repositories depuis le contexte
		UserRepo utilisateurRepository = ctx.getBean(UserRepo.class);

		// Ajout des données statiques en une seule ligne
		// Ajout des données statiques pour les utilisateurs uniquement
		List<User> utilisateurs = Arrays.asList(
				new User("user1", "nouhaila", "Dupont", "123nouha", new ArrayList<>()),
				new User("user2", "Khalid", "Martin", "123nouha", new ArrayList<>()),
				new User("user3", "Charlie", "Dupuis", "123nouha", new ArrayList<>()),
				new User("user4", "Diana", "Lefevre", "123nouha", new ArrayList<>())
		);
		// Sauvegarde de chaque utilisateur
		for (User utilisateur : utilisateurs) {
			utilisateurRepository.save(utilisateur);
		}
	}

}