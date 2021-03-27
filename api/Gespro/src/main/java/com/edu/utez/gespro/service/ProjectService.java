package com.edu.utez.gespro.service;

import com.edu.utez.gespro.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.utez.gespro.repository.ProjectRepository;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAll(){
        return projectRepository.findAll();
    }

    public Project getOne(long id) {
        return projectRepository.findById(id).get();
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public Project update(Project project, long id) {
        Project existente = getOne(id);
        existente.setName(project.getName());
        existente.setDuration(project.getDuration());
        existente.setDescription(project.getDescription());
        existente.setClientName(project.getClientName());
        existente.setDate(project.getDate());
        existente.setCost(project.getCost());
        existente.setEmploye(project.getEmploye());
        existente.setType(project.getType());
        return projectRepository.save(existente);
    }

    public void remove(long id) {
        projectRepository.deleteById(id);
    }
    
    public Project getOneByName(String name){
        return projectRepository.searchByName(name);
    }
}
