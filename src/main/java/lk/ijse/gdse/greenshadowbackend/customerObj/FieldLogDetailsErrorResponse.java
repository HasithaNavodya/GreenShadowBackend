package lk.ijse.gdse.greenshadowbackend.customerObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class FieldLogDetailsErrorResponse implements FieldLogDetailsResponse, Serializable {
    private int errorCode;
    private String errorMassage;
}
