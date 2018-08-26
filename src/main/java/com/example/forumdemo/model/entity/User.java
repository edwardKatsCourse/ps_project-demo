package com.example.forumdemo.model.entity;


import com.example.forumdemo.model.entity.converters.UserTypeConverter;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private String identificationNumber;

    @Column(unique = true)
    private String username;

    @Column(nullable = false)
    @Convert(converter = UserTypeConverter.class)
    private UserType userType;

//    private User parent;

    @CreatedDate
    private LocalDate createdOn;

}
