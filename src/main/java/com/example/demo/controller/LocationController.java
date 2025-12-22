package com.example.demo.controller;

import com.example.demo.dto.LocationDTO;
import com.example.demo.service.LocationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LocationDTO createLocation(@Valid @RequestBody LocationDTO locationDTO) {
        return locationService.createLocation(locationDTO);
    }

    @GetMapping("/{id}")
    public LocationDTO getLocation(@PathVariable Long id) {
        return locationService.getLocationById(id);
    }

    @GetMapping
    public List<LocationDTO> getAllLocations() {
        return locationService.getAllLocations();
    }

    @PutMapping("/{id}")
    public LocationDTO updateLocation(@PathVariable Long id,
                                      @Valid @RequestBody LocationDTO locationDTO) {
        return locationService.updateLocation(id, locationDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
    }
}