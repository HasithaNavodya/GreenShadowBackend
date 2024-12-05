package lk.ijse.gdse.greenshadowbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "staff_log_details")
public class StaffLogDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sl_id;

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Getter
    @ManyToOne
    @JoinColumn(name = "staff_id",referencedColumnName = "staff_id",nullable = false)
    private Staff staff;
    private String firstName;
    @ManyToOne
    @JoinColumn(name = "log_code",referencedColumnName = "log_code",nullable = false)
    private Log log;
    private String description;
    private int work_staff_count;
    private Date logDate;
}
