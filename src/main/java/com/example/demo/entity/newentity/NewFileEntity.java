package com.example.demo.newentity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
public class NewFileEntity{
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "should not contain spaces" )
    private String name;
    @NotBlank(message = "no blank allowed")
    @Email(message ="invalid format")
    private String email;
}