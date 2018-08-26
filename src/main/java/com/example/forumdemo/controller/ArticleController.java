package com.example.forumdemo.controller;

import com.example.forumdemo.model.entity.Article;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    public Article save() {
        return null;
    }

    public void delete() {

    }

}
