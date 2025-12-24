public interface ShipmentService {
    Shipment createShipment(Long vehicleId, Shipment s);
    Shipment getShipment(Long id);
}
