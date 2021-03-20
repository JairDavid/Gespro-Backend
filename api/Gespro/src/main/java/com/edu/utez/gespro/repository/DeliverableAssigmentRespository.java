package com.edu.utez.gespro.repository;

import com.edu.utez.gespro.entity.DeliverableAssigment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DeliverableAssigmentRespository extends JpaRepository<DeliverableAssigment,Long> {
	 @Query(value = "SELECT * FROM asignacion_entregables WHERE idfase_proyecto=:id", nativeQuery = true)
	 DeliverableAssigment selectOneDeliverableAssigment(@Param("id") long id);
}
