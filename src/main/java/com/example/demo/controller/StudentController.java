package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Studententity;
import com.example.demo.service.Studentservice;

@RestController
public class Studentcontroller {
    @Autowired
    Studentservice src;
    @PostMapping("/post")


    public Studententity postdata(@RequestBody Studententity st){
        return src.savedata(st);

    }
    @GetMapping("/status")
    public List<Studententity> getdata(){
        return src.retdata();
    }
    @GetMapping("/getid/{id}")
    public Studententity getIdVal(@PathVariable int id){
        return src.id(id);
    
    }
    @PutMapping("/update/{id}")
public String update(@PathVariable Long id, @RequestBody Student newStudent) {

    Optional<Student> student = studentService.getOneStudent(id);

    if (student.isPresent()) {
        newStudent.setId(id);
        studentService.insertStudent(newStudent);
        return "Updated Success";
    }

    return "Id not found";
}
    @DeleteMapping("/delete/{id}")
    public Studententity deleteStudent(@PathVariable int id){
        return src.deleteStudent(id);
        
    }

    
}
