package com.edu.utez.gespro.service;

import com.edu.utez.gespro.entity.TypePhase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.utez.gespro.repository.ProjectPhaseRepository;

import java.util.List;

@Service
public class ProjectPhaseService {
    @Autowired
    private ProjectPhaseRepository projectPhaseRepository;

    public List<TypePhase> getAll(){
        return projectPhaseRepository.findAll();
    }
    
    public List<TypePhase> getAllByTypeId(long id){
        return projectPhaseRepository.selectByIdType(id);
    }
    
    public List<TypePhase> getAllByPhaseId(long id){
        return projectPhaseRepository.selectByIdPhase(id);
    }
    
    public TypePhase getOne(long id) {
        return projectPhaseRepository.findById(id).get();
    }

    public TypePhase saveOrUpdate(TypePhase typePhase) {
        return projectPhaseRepository.save(typePhase);
    }

    public void remove(long id) {
        projectPhaseRepository.deleteById(id);
    }
}
