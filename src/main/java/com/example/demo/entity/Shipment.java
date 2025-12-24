@Entity
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Shipment {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Location pickupLocation;

    @ManyToOne
    private Location dropLocation;

    private Double weightKg;
    private LocalDate scheduledDate;
}
