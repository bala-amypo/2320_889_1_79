package com.example.demo.newentity;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;

public class NewFileEntity{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "should not contain spaces" )
    private String name;
    @NotBlank(message = "no blank allowed")
    @Email(message ="invalid format")
    private String email;
    
}