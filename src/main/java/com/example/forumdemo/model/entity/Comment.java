package com.example.forumdemo.model.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String commentText;

    @ManyToOne
    private Article article;

    //                  COMMENT
    //ID    COMMENT_TEXT    ARTICLE_ID  COMMENTED_BY
    //1         blah            1           1
    //2         blah            1           1
    //3         blah            2           1
    //4         blah            2           1
    //5         blah            1           1


    //ThisTOUser
    @ManyToOne
    private User commentedBy;

    @CreatedDate
    private LocalDateTime createdOn;

}
