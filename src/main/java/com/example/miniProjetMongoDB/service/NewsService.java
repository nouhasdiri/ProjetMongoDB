package com.example.miniProjetMongoDB.service;

import com.example.miniProjetMongoDB.model.Commentaire;
import com.example.miniProjetMongoDB.model.News;
import com.example.miniProjetMongoDB.repository.NewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    @Autowired
    private NewsRepo repository;

    public News addNews(String url, String title, String author, List<Commentaire> commentaires) {
        News news = new News();
        news.setUrl(url);
        news.setTitre(title);
        news.setAuteur(author);
        news.setDate(new Date());
        news.setCommentaires(commentaires);
        return repository.save(news);
        }

    public Optional<News> getNewsbyId(String id){
        return repository.findById(id);
    }
    public List<News> getAllNews(){
        return repository.findAll();
    }

    public void likeNews(String id, String userId) {
        repository.findById(id).ifPresent(news -> {
            if (!news.getLikedByUsers().contains(userId)) {
                news.getLikedByUsers().add(userId);
                news.setLikes(news.getLikes() + 1);
                repository.save(news);
            }
        });
    }
    public void dislikeNews(String id, String userId) {
        repository.findById(id).ifPresent(news -> {
            if (!news.getDislikedByUsers().contains(userId)) {
                news.getDislikedByUsers().add(userId);
                news.setDislikes(news.getDislikes() + 1);
                repository.save(news);
            }
        });
    }
}




