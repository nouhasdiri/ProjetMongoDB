package com.example.miniProjetMongoDB.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collation = "news")
public class News {
    @Id
    private String url;
    private String titre;
    private String auteur;
    private Date date;
    private List<String> likes;
    private List<String> dislikes;
    private List<Commentaire> commentaires;
}
