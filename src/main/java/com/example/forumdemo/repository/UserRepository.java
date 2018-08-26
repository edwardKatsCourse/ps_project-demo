package com.example.forumdemo.repository;

import com.example.forumdemo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByIdAndUsername(Long userId, String username);
    boolean existsByUsername(String username);
}
