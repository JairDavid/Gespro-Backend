package com.edu.utez.gespro.repository;

import com.edu.utez.gespro.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Long> {
    @Query(value="SELECT * FROM tipo WHERE idtipo NOT IN (SELECT idtipo FROM fase_tipo)", nativeQuery = true)
    List<Type>getNotAssigned();
}
