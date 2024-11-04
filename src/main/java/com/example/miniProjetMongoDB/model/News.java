package com.example.miniProjetMongoDB.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collation = "news")
public class News {
    @Id
    private String id;
    private String url;
    private String titre;
    private String auteur;
    private Date date;
    private Integer likes;
    private Integer dislikes;
    private List<Commentaire> commentaires;
    private Set<String> LikedByUsers = new HashSet<>();
    private Set<String> DislikedByUsers = new HashSet<>();
}
