package lk.ijse.gdse68.greenshadowbackend.service;

import lk.ijse.gdse68.greenshadowbackend.dto.EquipmentDTO;
import lk.ijse.gdse68.greenshadowbackend.dto.FieldLogDetailsDTO;
import lk.ijse.gdse68.greenshadowbackend.dto.LogDTO;

import java.util.List;

public interface FieldLogDetailsService {

    void saveFieldLogDetails(LogDTO logDTO);
    List<FieldLogDetailsDTO> getAllFieldLogDetails();

    String generateLogCode();
}
