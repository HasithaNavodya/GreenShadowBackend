package lk.ijse.gdse.greenshadowbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

//04
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class AuthDTO {
    private String email;
    private String token;
    private String refreshToken;
    private String role; // Add this field

}
