package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO dto);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
}
