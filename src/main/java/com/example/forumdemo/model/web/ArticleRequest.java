package com.example.forumdemo.model.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ArticleRequest {

    private Long userId;
    private String header;
    private String text;

}
