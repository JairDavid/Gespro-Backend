package com.edu.utez.gespro.repository;

import com.edu.utez.gespro.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	@Query(value = "SELECT * FROM proyecto WHERE nombre=:name", nativeQuery = true)
    Project searchByName(@Param("name") String name);
}
