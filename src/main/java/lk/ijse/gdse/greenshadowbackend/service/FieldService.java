package lk.ijse.gdse68.greenshadowbackend.service;

import lk.ijse.gdse68.greenshadowbackend.customerObj.FieldResponse;
import lk.ijse.gdse68.greenshadowbackend.customerObj.StaffResponse;
import lk.ijse.gdse68.greenshadowbackend.dto.FieldDTO;
import lk.ijse.gdse68.greenshadowbackend.dto.StaffDTO;

import java.util.List;


public interface FieldService {

    void saveField(FieldDTO fieldDTO);
    void updateField(FieldDTO fieldDTO) throws ClassNotFoundException;
    void deleteField(String fieldCode);
    FieldResponse getSelectedField(String fieldCode);
    List<FieldDTO> getAllField();
    List<FieldResponse> getFieldByFieldName(String fieldName);
}
