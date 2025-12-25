package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.entity.Vehicle;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepo;
    private final UserRepository userRepo;

    public VehicleServiceImpl(VehicleRepository v, UserRepository u){
        this.vehicleRepo = v;
        this.userRepo = u;
    }

    public Vehicle addVehicle(Long userId, Vehicle vehicle){
        if(vehicle.getCapacityKg() <= 0)
            throw new IllegalArgumentException("Capacity must be positive and contain word Capacity");

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        vehicle.setUser(user);
        return vehicleRepo.save(vehicle);
    }

    public List<Vehicle> getVehiclesByUser(Long userId){
        return vehicleRepo.findByUserId(userId);
    }
}
