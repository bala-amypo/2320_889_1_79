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
    public NewFileEntity(Long id,@NotBlank(message="should not contain spaces") String name,@NotBlank(message ="no blank allowed")
    @Email(message = "Invalid format") String email)
    {
          this.name = name;
        this.id = id;
        this.email = email;
    }
   
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
   
    public NewFileEntity() {
    }
    

    
    
    

}
}