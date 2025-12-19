package demo.dto;

public class ShipmentDTO {
    private Long locationId;
    private Long vehicleId;

    // Getters and Setters
    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
}
