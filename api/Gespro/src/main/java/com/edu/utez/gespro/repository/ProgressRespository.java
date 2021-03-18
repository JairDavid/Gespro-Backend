package com.edu.utez.gespro.repository;

import com.edu.utez.gespro.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProgressRespository extends JpaRepository<Progress, Long> {

    @Query(value = "SELECT * from avance where idproyecto=:idP and terminado=1", nativeQuery = true)
    public List<Progress> searchByIdProject(@Param("idP") long id);

    @Query(value = "SELECT * FROM avance WHERE terminado=1", nativeQuery = true)
    public List<Progress> searchAllTrue();
}
