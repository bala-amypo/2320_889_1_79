package com.example.demo.controller;

import com.example.demo.entity.Location;
import com.example.demo.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationService service;

    public LocationController(LocationService service){
        this.service = service;
    }

    @PostMapping
    public Location create(@RequestBody Location l){
        return service.create(l);
    }

    @GetMapping
    public List<Location> getAll(){
        return service.getAll();
    }
}
