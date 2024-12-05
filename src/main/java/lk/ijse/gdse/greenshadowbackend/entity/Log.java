package lk.ijse.gdse.greenshadowbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "logs")
public class Log {
    @Id
    @Column(name = "log_code", nullable = false)
    private String logCode;
    @Column(name = "log_date")
    private Date logDate;
    @Column(name = "log_details")
    private String logDetails;
    @Column(name = "observed_image", columnDefinition = "LONGTEXT")
    private String observedImage;
    // Define the many-to-one relationship with Crop
    @ManyToOne
    @JoinColumn(name = "crop_code")
    private Crop crop;

    @OneToMany(mappedBy = "log",cascade = CascadeType.ALL)
    private List<FieldLogDetails> fieldLogDetails;

    @OneToMany(mappedBy = "log",cascade = CascadeType.ALL)
    private List<StaffLogDetails> staffLogDetails;


}
