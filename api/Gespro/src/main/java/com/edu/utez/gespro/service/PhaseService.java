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

    public Phase save(Phase phase) {
        return phaseRespository.save(phase);
    }
    
    public boolean getName(String name) {
    	try {
    		Phase dato = phaseRespository.searchByName(name);
    		if(dato.getName() != null || dato.getName()!="") {
    			return true;
    		}
    		return false;
    	}catch (Exception e) {
    		return false;
		}
    }
    
    public Phase update(Phase nuevo, long id) {
        Phase phase = getOne(id);
        phase.setName(nuevo.getName());
        return phaseRespository.save(phase);
    }

    public void remove(long id) {
        phaseRespository.deleteById(id);
    }
}
