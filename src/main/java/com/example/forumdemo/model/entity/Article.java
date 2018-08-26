package com.example.forumdemo.model.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Article implements Persistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String header;

    private String text;

    @ManyToOne
    private User createdBy;

    @CreatedDate
    private LocalDateTime createdOn;

//    @LastModifiedDate


    @Override
    public boolean isNew() {
        return getId() == null;
    }
}
