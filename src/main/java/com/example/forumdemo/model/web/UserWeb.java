package com.example.forumdemo.model.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserWeb {

    private Long userId;

    @Length(min = 3, max = 20, message = "Username length should be between 3 and 20 characters")
    @NotBlank(message = "Username cannot be blank")
    private String username;

    @Email(message = "Email format is incorrect")
    @NotBlank(message = "Email cannot be blank")
    @Length(min = 3, max = 20, message = "Email length should be between 3 and 20 characters")
    private String email;

}
