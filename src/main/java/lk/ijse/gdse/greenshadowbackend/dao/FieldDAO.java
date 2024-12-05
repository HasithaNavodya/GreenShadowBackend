package lk.ijse.gdse68.greenshadowbackend.dao;

import lk.ijse.gdse68.greenshadowbackend.entity.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FieldDAO extends JpaRepository<Field,String> {
    List<Field> findByFieldNameContainingIgnoreCase(String fieldName);
}

