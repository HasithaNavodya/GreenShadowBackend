package lk.ijse.gdse.greenshadowbackend.customerObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffFieldDetailsErrorResponse implements StaffFieldDetailsResponse, Serializable {
    private int errorCode;
    private String errorMassage;
}
