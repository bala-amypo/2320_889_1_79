package com.example.demo.newrepository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.newentity.NewFileEntity;
public interface NewFileEntity extends JpaRepository<NewFileEntity,Long>{
    
}