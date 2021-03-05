package com.edu.utez.gespro.service;

import com.edu.utez.gespro.entity.ProjectPhase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.utez.gespro.repository.ProjectPhaseRepository;

import java.util.List;

@Service
public class ProjectPhaseService {
    @Autowired
    private ProjectPhaseRepository projectPhaseRepository;

    public List<ProjectPhase> getAll(){
        return projectPhaseRepository.findAll();
    }

    public ProjectPhase getOne(long id) {
        return projectPhaseRepository.findById(id).get();
    }

    public ProjectPhase saveOrUpdate(ProjectPhase projectPhase) {
        return projectPhaseRepository.save(projectPhase);
    }

    public void remove(long id) {
        projectPhaseRepository.deleteById(id);
    }
}
