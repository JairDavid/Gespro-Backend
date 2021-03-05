package com.edu.utez.gespro.repository;

import com.edu.utez.gespro.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeRepository extends JpaRepository<Employe,Long> {

    @Query(value = "SELECT * from empleado where email =:correo",nativeQuery = true)
    Employe searchByEmail(@Param("correo") String email);

}
