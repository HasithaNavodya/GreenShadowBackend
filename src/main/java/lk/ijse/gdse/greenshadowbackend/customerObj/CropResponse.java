package lk.ijse.gdse.greenshadowbackend.customerObj;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface CropResponse {
    // Method to set image using MultipartFile
    void setCropImage(MultipartFile image);

    String encodeImageToBase64(MultipartFile image) throws IOException;
}
