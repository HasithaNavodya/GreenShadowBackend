package lk.ijse.gdse.greenshadowbackend.customerObj;

import org.springframework.web.multipart.MultipartFile;

public interface FieldResponse {
    // Method to set images using MultipartFile
    void setFieldImages(MultipartFile image1, MultipartFile image2);
}
