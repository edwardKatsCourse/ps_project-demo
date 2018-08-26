package com.example.forumdemo.model.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ArticleResponse {

    private Long articleId;
    private String header;
    private String text;
    private String createdBy;
    private LocalDate createdOn;

    private Set<CommentResponse> commentResponses;

}
