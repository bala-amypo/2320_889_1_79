public class LocationServiceImpl implements LocationService {

    private final LocationRepository repo;

    public LocationServiceImpl(LocationRepository repo) {
        this.repo = repo;
    }

    @Override
    public Location createLocation(Location l) {
        if (l.getLatitude() > 90 || l.getLatitude() < -90)
            throw new IllegalArgumentException("latitude invalid");

        return repo.save(l);
    }

    @Override
    public List<Location> getAllLocations() {
        return repo.findAll();
    }
}
