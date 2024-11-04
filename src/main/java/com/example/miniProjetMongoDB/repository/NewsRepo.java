package com.example.miniProjetMongoDB.repository;

import com.example.miniProjetMongoDB.model.News;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsRepo extends MongoRepository<News, String> {
}
