package com.edu.utez.gespro.repository;

import com.edu.utez.gespro.entity.Deliverable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DeliverableRepository extends JpaRepository<Deliverable,Long> {
	@Query(value = "SELECT * from entregable where nombre =:nombre",nativeQuery = true)
    Deliverable searchByName(@Param("nombre") String name);
}
