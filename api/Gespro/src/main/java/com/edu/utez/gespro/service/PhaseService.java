package com.edu.utez.gespro.service;

import com.edu.utez.gespro.entity.Phase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.utez.gespro.repository.PhaseRespository;

import java.util.List;

@Service
public class PhaseService {
    @Autowired
    private PhaseRespository phaseRespository;

    public List<Phase> getAll(){
        return phaseRespository.findAll();
    }

    public Phase getOne(long id) {
        return phaseRespository.findById(id).get();
    }

    public Phase saveOrUpdate(Phase phase) {
        return phaseRespository.save(phase);
    }

    public void remove(long id) {
        phaseRespository.deleteById(id);
    }
}
