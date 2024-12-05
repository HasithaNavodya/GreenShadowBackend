package lk.ijse.gdse.greenshadowbackend.customerObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CropErrorResponse  implements CropResponse{
    private int errorCode;
    private String errorMassage;

    @Override
    public void setCropImage(MultipartFile image) {

    }

    @Override
    public String encodeImageToBase64(MultipartFile image) throws IOException {
        return null;
    }
}
