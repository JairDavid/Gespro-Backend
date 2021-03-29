package com.edu.utez.gespro.repository;


import com.edu.utez.gespro.entity.Phase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PhaseRespository extends JpaRepository<Phase, Long> {
	@Query(value = "SELECT * from fase where nombre =:nombre",nativeQuery = true)
    Phase searchByName(@Param("nombre") String name);
}
