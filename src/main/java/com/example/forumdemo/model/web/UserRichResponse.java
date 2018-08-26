package com.example.forumdemo.model.web;

import com.example.forumdemo.model.entity.UserType;
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
public class UserRichResponse {

    private Long userId;
    private String username;
    private UserType userType;
    private LocalDate createdOn;

    private Set<Long> createdArticles;
    private Set<Long> comments;

}
