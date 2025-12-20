package com.example.demo.service;

import com.example.demo.dto.*;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO dto);

    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();

    void deleteUser(Long id);

    AuthResponse login(AuthRequest request);
}
