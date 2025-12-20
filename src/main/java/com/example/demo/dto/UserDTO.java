package com.example.demo.dto;

public class UserDTO {

    private Long id;
    private String email;
    private String password;
    private String role;

    // ✅ No-args constructor (REQUIRED)
    public UserDTO() {
    }

    // ✅ Parameterized constructor (FIXES ERROR #3)
    public UserDTO(Long id, String email, String password, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // ✅ Getters & Setters (FIXES ERROR #1)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {      // 🔥 REQUIRED
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
