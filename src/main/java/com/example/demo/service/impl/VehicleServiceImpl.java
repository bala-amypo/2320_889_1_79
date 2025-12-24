public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repo;
    private final UserRepository userRepo;

    public VehicleServiceImpl(VehicleRepository r, UserRepository u) {
        this.repo = r;
        this.userRepo = u;
    }

    public Vehicle addVehicle(Long userId, Vehicle v) {
        if (v.getCapacityKg() <= 0)
            throw new IllegalArgumentException("Capacity invalid");

        User u = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        v.setUser(u);
        return repo.save(v);
    }

    public Vehicle findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found"));
    }

    public List<Vehicle> getVehiclesByUser(Long id) {
        return repo.findByUserId(id);
    }
}
