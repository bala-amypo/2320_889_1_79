@Entity
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class RouteOptimizationResult {
    @Id @GeneratedValue
    private Long id;

    @OneToOne
    private Shipment shipment;

    private Double optimizedDistanceKm;
    private Double estimatedFuelUsageL;
    private LocalDateTime generatedAt;
}
