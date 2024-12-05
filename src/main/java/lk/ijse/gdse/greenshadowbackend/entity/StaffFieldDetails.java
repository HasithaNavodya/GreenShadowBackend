package lk.ijse.gdse.greenshadowbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "staff_field_details")
public class StaffFieldDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sf_id;

    @ManyToOne
    @JoinColumn(name = "staff_id",referencedColumnName = "staff_id",nullable = false)
    private Staff staff;
    private String firstName;
    @ManyToOne
    @JoinColumn(name = "field_code",referencedColumnName = "field_code",nullable = false)
    private Field field;
    @Column(name = "status")
    private String status;
    private String description;
    private int work_staff_count;
    private Date date;
}
