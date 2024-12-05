package lk.ijse.gdse68.greenshadowbackend.dao;

import lk.ijse.gdse68.greenshadowbackend.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VehicleDAO extends JpaRepository<Vehicle,String> {
    List<Vehicle> findByVehicleCategoryContainingIgnoreCase(String vehicleCategory);
}
