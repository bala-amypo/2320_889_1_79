package com.example.demo.entity;
import jakarta.persistence.*;

public class User{
    @Id 
    private Long id;
    private String name;
    @Column(unique=true)
    private String email;
    private String ADMIN;
    private String USER;

    public User(Long id, String name, String email, String aDMIN, String uSER) {
        this.id = id;
        this.name = name;
        this.email = email;
        ADMIN = aDMIN;
        USER = uSER;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getADMIN() {
        return ADMIN;
    }

    public void setADMIN(String aDMIN) {
        ADMIN = aDMIN;
    }

    public String getUSER() {
        return USER;
    }

    public void setUSER(String uSER) {
        USER = uSER;
    }
}

