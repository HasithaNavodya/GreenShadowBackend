package lk.ijse.gdse.greenshadowbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @Column(name = "vehicle_code", nullable = false, unique = true)
    private String vehicleCode;

    @Column(name = "license_plate_number", nullable = false, unique = true)
    private String licensePlateNumber;

    @Column(name = "vehicle_category")
    private String vehicleCategory;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "status")
    private String status; // "Available" or "Out of Service"

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff usedBy; // Staff member assigned to this vehicle

    @Column(name = "remarks")
    private String remarks;
}
