@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepo;
    private final UserRepository userRepo;

    public VehicleServiceImpl(VehicleRepository v, UserRepository u){
        this.vehicleRepo = v;
        this.userRepo = u;
    }

    public VehicleServiceImpl() {
        this.vehicleRepo = null;
        this.userRepo = null;
    }
}
