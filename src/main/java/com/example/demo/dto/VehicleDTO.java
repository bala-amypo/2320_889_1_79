public class VehicleDTO {

    private Long id;
    private String vehicleNumber;
    private Double capacityKg;
    private Double fuelEfficiency;

    public VehicleDTO() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Double getCapacityKg() {
        return capacityKg;
    }
    public void setCapacityKg(Double capacityKg) {
        this.capacityKg = capacityKg;
    }

    public Double getFuelEfficiency() {
        return fuelEfficiency;
    }
    public void setFuelEfficiency(Double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }
}
