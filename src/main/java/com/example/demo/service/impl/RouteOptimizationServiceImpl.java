public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository shipmentRepo;
    private final RouteOptimizationResultRepository resultRepo;

    public RouteOptimizationServiceImpl(ShipmentRepository s, RouteOptimizationResultRepository r) {
        this.shipmentRepo = s;
        this.resultRepo = r;
    }

    @Override
    public RouteOptimizationResult optimizeRoute(Long shipmentId) {
        var shipment = shipmentRepo.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        double dist = Math.hypot(
                shipment.getPickupLocation().getLatitude() - shipment.getDropLocation().getLatitude(),
                shipment.getPickupLocation().getLongitude() - shipment.getDropLocation().getLongitude()
        );

        double fuel = dist / shipment.getVehicle().getFuelEfficiency();

        RouteOptimizationResult r = RouteOptimizationResult.builder()
                .shipment(shipment)
                .optimizedDistanceKm(dist)
                .estimatedFuelUsageL(fuel)
                .build();

        return resultRepo.save(r);
    }

    @Override
    public RouteOptimizationResult getResult(Long id) {
        return resultRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
