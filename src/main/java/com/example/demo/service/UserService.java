package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();

    void deleteUser(Long id);

    String login(AuthRequest request);
}
