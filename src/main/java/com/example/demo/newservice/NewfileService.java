package com.example.demo.newservice;
import com.example.demo.newentity.NewFileEntity;
public interface NewfileService{
    NewFileEntity savedata(NewFileEntity newfile);
    NewFileEntity getidval(Long id);
    List<NewFileEntity> getall();
    NewFileEntity update(Long id,NewFileEntity newfile);
    void delete(Long id);
    
}