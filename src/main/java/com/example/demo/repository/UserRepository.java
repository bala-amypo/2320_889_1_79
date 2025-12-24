package com.example.demo.repository;

import java.util.*;

public interface UserRepository {
    User save(User u);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
}
