package com.example.miniProjetMongoDB.service;

import com.example.miniProjetMongoDB.repository.NewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

    @Autowired
    private NewsRepo newsRepo;



}
