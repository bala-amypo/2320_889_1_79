public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepo;
    private final VehicleRepository vehicleRepo;
    private final LocationRepository locationRepo;

    public ShipmentServiceImpl(ShipmentRepository s, VehicleRepository v, LocationRepository l) {
        this.shipmentRepo = s;
        this.vehicleRepo = v;
        this.locationRepo = l;
    }

    @Override
    public Shipment createShipment(Long vehicleId, Shipment s) {
        var vehicle = vehicleRepo.findById(vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));

        if (s.getWeightKg() > vehicle.getCapacityKg())
            throw new IllegalArgumentException("exceeds capacity");

        if (s.getScheduledDate().isBefore(java.time.LocalDate.now()))
            throw new IllegalArgumentException("past date");

        var pickup = locationRepo.findById(s.getPickupLocation().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Location not found"));

        var drop = locationRepo.findById(s.getDropLocation().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Location not found"));

        s.setVehicle(vehicle);
        s.setPickupLocation(pickup);
        s.setDropLocation(drop);

        return shipmentRepo.save(s);
    }

    @Override
    public Shipment getShipment(Long id) {
        return shipmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));
    }
}
