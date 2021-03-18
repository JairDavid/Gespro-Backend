package com.edu.utez.gespro.repository;

import com.edu.utez.gespro.entity.AttachedResource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AttachedResourceRepository extends CrudRepository<AttachedResource,Long> {

    @Query(value = "SELECT * FROM asignar_adscrito where idempleado=:id", nativeQuery = true)
    List<AttachedResource> searchByIdEmp(@Param("id") long id);

    @Query(value = "SELECT * from asignar_adscrito", nativeQuery = true)
    List<AttachedResource> searchAll();
}
