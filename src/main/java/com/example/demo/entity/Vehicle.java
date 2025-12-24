@Entity
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Vehicle {
    @Id @GeneratedValue
    private Long id;
    private String vehicleNumber;
    private Double capacityKg;
    private Double fuelEfficiency;

    @ManyToOne
    private User user;
}
