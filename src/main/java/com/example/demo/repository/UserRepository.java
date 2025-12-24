package com.example.demo.repository;

import com.example.demo.entity.User;   // ✅ REQUIRED
import java.util.Optional;

public interface UserRepository {
    User save(User u);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
}
