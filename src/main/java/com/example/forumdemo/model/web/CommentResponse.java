package com.example.forumdemo.model.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CommentResponse {

    private String username;
    private Long commentId;
    private String commentText;
}
