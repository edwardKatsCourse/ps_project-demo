package com.example.forumdemo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum UserType {
    /**
     * GUEST - until created the first article
     * REGULAR - until created 3 articles
     *           may comment other users' articles, may delete ITS article only, may delete ITS comments
     * ADMIN - may delete any article, may delete any article
     */
    GUEST(1),
    REGULAR(2),
    ADMIN(3);

    private Integer id;

    public static UserType getById(Integer id) {
        return Arrays.stream(values())
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(UserType.GUEST);
    }
}
