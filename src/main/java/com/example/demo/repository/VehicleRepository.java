public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByUserId(Long userId);
    Optional<Vehicle> findByVehicleNumber(String num);
}
