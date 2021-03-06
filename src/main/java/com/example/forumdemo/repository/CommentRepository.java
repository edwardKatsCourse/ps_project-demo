package com.example.forumdemo.repository;

import com.example.forumdemo.model.entity.Article;
import com.example.forumdemo.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByArticle(Article article);
}
