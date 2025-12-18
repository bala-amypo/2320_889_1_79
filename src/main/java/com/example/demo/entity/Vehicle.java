package com.example.demo.entity;
import jakarta.persistence.Id;
public class Vehicle{
    @Id
    private Long id;
    @Column()
    private String vehicleNumber;

}