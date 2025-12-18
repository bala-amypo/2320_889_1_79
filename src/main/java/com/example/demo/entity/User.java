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

}