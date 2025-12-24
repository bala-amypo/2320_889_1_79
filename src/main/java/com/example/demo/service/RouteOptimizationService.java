public interface RouteOptimizationService {
    RouteOptimizationResult optimizeRoute(Long shipmentId);
    RouteOptimizationResult getResult(Long id);
}
