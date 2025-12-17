package com.example.demo.newentity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
public class NewFileEntity{
    @Id
    private Long id;
    @NotBlank(message = should not contain spaces)
    private String name;
    private String email;
}