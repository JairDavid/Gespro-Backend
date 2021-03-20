package com.edu.utez.gespro.repository;

import com.edu.utez.gespro.entity.TypePhase;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectPhaseRepository extends JpaRepository<TypePhase,Long> {
	@Query(value = "SELECT * FROM fase_tipo WHERE idtipo=:id", nativeQuery = true)
    List<TypePhase> selectByIdType(@Param("id") long id);
}
