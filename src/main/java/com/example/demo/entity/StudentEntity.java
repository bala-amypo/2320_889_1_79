package com.example.demo.entity;

import java.time.LocalDate;

public class Studententity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @GeneratedValue(strategy = GenerationType.Auto)
    private String name;
    @column(name=unique)
    private String email;
    private int id;
    private LocalDate date;
    private float cgpa;
    public String getName() {
        return name;
    }
    public Studententity(String name, int id, LocalDate date, float cgpa) {
        this.name = name;
        this.id = id;
        this.date = date;
        this.cgpa = cgpa;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getDate() {
        return date;
    }
    public Studententity() {
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public float getCgpa() {
        return cgpa;
    }
    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }
    
    
    
}
