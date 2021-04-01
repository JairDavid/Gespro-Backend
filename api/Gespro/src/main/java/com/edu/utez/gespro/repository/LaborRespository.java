package com.edu.utez.gespro.repository;

import com.edu.utez.gespro.entity.Labor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LaborRespository extends JpaRepository<Labor,Long> {
    @Query(value = "SELECT * FROM puesto WHERE nombre=:name", nativeQuery = true)
    Labor searchByName(@Param("name") String name);

}
