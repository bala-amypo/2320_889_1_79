public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository repo;
    private final VehicleRepository vehicleRepo;
    private final LocationRepository locationRepo;

    public ShipmentServiceImpl(ShipmentRepository r, VehicleRepository v, LocationRepository l) {
        this.repo = r;
        this.vehicleRepo = v;
        this.locationRepo = l;
    }

    public Shipment createShipment(Long vehicleId, Shipment s) {

        if (s.getScheduledDate().isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Past date");

        Vehicle v = vehicleRepo.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        if (s.getWeightKg() > v.getCapacityKg())
            throw new IllegalArgumentException("Exceeds capacity");

        s.setVehicle(v);
        s.setPickupLocation(locationRepo.findById(s.getPickupLocation().getId()).orElseThrow());
        s.setDropLocation(locationRepo.findById(s.getDropLocation().getId()).orElseThrow());

        return repo.save(s);
    }

    public Shipment getShipment(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
    }
}
