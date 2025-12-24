public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final ShipmentRepository repo;
    private final RouteOptimizationResultRepository resultRepo;

    public RouteOptimizationServiceImpl(ShipmentRepository r, RouteOptimizationResultRepository rr) {
        this.repo = r;
        this.resultRepo = rr;
    }

    public RouteOptimizationResult optimizeRoute(Long shipmentId) {
        Shipment s = repo.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        double dist = Math.hypot(
                s.getPickupLocation().getLatitude() - s.getDropLocation().getLatitude(),
                s.getPickupLocation().getLongitude() - s.getDropLocation().getLongitude()
        );

        RouteOptimizationResult r = RouteOptimizationResult.builder()
                .shipment(s)
                .optimizedDistanceKm(dist)
                .estimatedFuelUsageL(dist / s.getVehicle().getFuelEfficiency())
                .generatedAt(LocalDateTime.now())
                .build();

        return resultRepo.save(r);
    }

    public RouteOptimizationResult getResult(Long id) {
        return resultRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
