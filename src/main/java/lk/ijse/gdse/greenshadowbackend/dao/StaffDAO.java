package lk.ijse.gdse68.greenshadowbackend.dao;

import lk.ijse.gdse68.greenshadowbackend.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StaffDAO extends JpaRepository<Staff,String> {
    List<Staff> findByFirstNameContainingIgnoreCase(String firstName);


}
