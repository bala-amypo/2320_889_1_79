public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final BCryptPasswordEncoder encoder;

    public UserServiceImpl(UserRepository r, BCryptPasswordEncoder e) {
        this.repo = r;
        this.encoder = e;
    }

    public User register(User u) {
        u.setPassword(encoder.encode(u.getPassword()));
        if (u.getRole() == null) u.setRole("USER");
        return repo.save(u);
    }

    public User findByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public User findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
