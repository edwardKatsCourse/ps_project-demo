package com.example.forumdemo.controller;

import com.example.forumdemo.exceptions.InputValidationException;
import com.example.forumdemo.exceptions.UserDuplicationException;
import com.example.forumdemo.model.entity.User;
import com.example.forumdemo.model.web.UserRichResponse;
import com.example.forumdemo.model.web.UserWeb;
import com.example.forumdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public UserWeb createUser(@RequestBody @Valid UserWeb userWeb, BindingResult result) {

        if (result.hasErrors()) {
            throw new InputValidationException(result);
        }

        if (userRepository.existsByUsername(userWeb.getUsername())) {
            throw new UserDuplicationException(userWeb.getUsername());
        }

        User user = User
                .builder()
                .username(userWeb.getUsername())
                .createdOn(LocalDate.now())
                .build();

        userRepository.save(user);

        userWeb.setUserId(user.getId());
        return userWeb;
    }

    @GetMapping("/regular/{userId}")
    public UserWeb getRegularUserInfo(@PathVariable("userId") Long userId) {
        return userRepository
                .findById(userId)
                .map(x -> UserWeb
                        .builder()
                        .userId(x.getId())
                        .username(x.getUsername())
                        .build())
                .orElse(null);

    }

    @PostMapping("/rich")
    public UserRichResponse getRichUserInfo(@RequestBody UserWeb userWeb) {
        User user = userRepository.findByIdAndUsername(userWeb.getUserId(), userWeb.getUsername());
        if (user == null) {
            return null;
        }

        return UserRichResponse.builder()
                .userId(user.getId())
                .username(user.getUsername())
                .userType(user.getUserType())
                .createdOn(user.getCreatedOn())
                .build();
    }


}
