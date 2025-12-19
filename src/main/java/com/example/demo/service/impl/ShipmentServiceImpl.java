package demo.service.impl;

import demo.entity.Location;
import demo.entity.Vehicle;
import demo.repository.LocationRepository;
import demo.repository.VehicleRepository;
import demo.dto.ShipmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl {

    @Autowired
    private LocationRepository locationRepository;  // Inject the LocationRepository

    @Autowired
    private VehicleRepository vehicleRepository;  // Inject the VehicleRepository

    private ShipmentDTO dto;  // Declare ShipmentDTO

    // A method to demonstrate usage of repositories and DTO
    public void someMethod() {
        if (dto != null) {
            // Fetch the location by ID from locationRepository
            Location location = locationRepository.findById(dto.getLocationId())
                    .orElseThrow(() -> new RuntimeException("Location not found"));

            // Fetch the vehicle by ID from vehicleRepository
            Vehicle vehicle = vehicleRepository.findById(dto.getVehicleId())
                    .orElseThrow(() -> new RuntimeException("Vehicle not found"));

            // You can now use location and vehicle objects in your business logic
            System.out.println("Location: " + location.getName());
            System.out.println("Vehicle: " + vehicle.getVehicleNumber());
        } else {
            // Handle the case when the dto is null or not initialized
            System.out.println("DTO is not initialized");
        }
    }

    // Getter and Setter for DTO (to set it from outside the service)
    public ShipmentDTO getDto() {
        return dto;
    }

    public void setDto(ShipmentDTO dto) {
        this.dto = dto;
    }
}
