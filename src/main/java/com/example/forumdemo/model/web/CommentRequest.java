package com.example.forumdemo.model.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CommentRequest {

    private Long userId;
    private Long articleId;
    private String commentText;
}
