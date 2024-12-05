package lk.ijse.gdse68.greenshadowbackend.service;

import lk.ijse.gdse68.greenshadowbackend.customerObj.StaffResponse;
import lk.ijse.gdse68.greenshadowbackend.customerObj.VehicleResponse;
import lk.ijse.gdse68.greenshadowbackend.dto.StaffDTO;
import lk.ijse.gdse68.greenshadowbackend.dto.VehicleDTO;

import java.util.List;


public interface VehicleService {

    void saveVehicle(VehicleDTO vehicleDTO);
    void updateVehicle(String vehicleCode,VehicleDTO vehicleDTO);
    void deleteVehicle(String vehicleCode);
    VehicleResponse getSelectedVehicleId(String vehicleCode);

    List<VehicleDTO> getAllVehicle();

    List<VehicleResponse> getVehicleByVehicleCategory(String vehicleCategory);
}
