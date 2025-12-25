package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String role;

    public User(){}

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String n){ this.name=n;}
    public String getEmail(){ return email;}
    public void setEmail(String e){ this.email=e;}
    public String getPassword(){ return password;}
    public void setPassword(String p){ this.password=p;}
    public String getRole(){ return role;}
    public void setRole(String r){ this.role=r;}
}
