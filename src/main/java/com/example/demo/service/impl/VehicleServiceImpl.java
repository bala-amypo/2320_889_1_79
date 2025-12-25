package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.entity.Vehicle;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public Vehicle save(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleRepo.findAll();
    }

    @Override
    public Optional<Vehicle> findById(long id) {
        return vehicleRepo.findById(id);
    }

    @Override
    public Vehicle addVehicle(Long userId, Vehicle vehicle) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        vehicle.setUser(user);
        return vehicleRepo.save(vehicle);
    }

    @Override
    public List<Vehicle> getVehiclesByUser(Long userId) {
        return vehicleRepo.findByUserId(userId);
    }
}
