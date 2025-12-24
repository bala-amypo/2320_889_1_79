public interface VehicleService {
    Vehicle addVehicle(Long userId, Vehicle vehicle);
    List<Vehicle> getVehiclesByUser(Long userId);
    Vehicle findById(Long id);
}
