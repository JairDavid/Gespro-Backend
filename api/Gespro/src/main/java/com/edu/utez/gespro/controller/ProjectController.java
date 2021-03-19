package com.edu.utez.gespro.controller;

import com.edu.utez.gespro.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.edu.utez.gespro.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/consultarTodos")
    public List<Project> listAll(){
        return projectService.getAll();
    }

    @GetMapping("/consultaUnica/{id}")
    public Project edit(@PathVariable("id") long id){
        return projectService.getOne(id);
    }

    @PostMapping("/guardar")
    public Project save(@RequestBody Project project){
        return projectService.saveOrUpdate(project);
    }

    @PutMapping("/actualizar/{id}")
    public Project update(@RequestBody Project project, @PathVariable("id") long id){
        Project existente = projectService.getOne(id);
        existente.setName(project.getName());
        existente.setDuration(project.getDuration());
        existente.setDescription(project.getDescription());
        existente.setClientName(project.getClientName());
        existente.setDate(project.getDate());
        existente.setCost(project.getCost());
        return projectService.saveOrUpdate(existente);
    }


    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable("id") long id){
        projectService.remove(id);
    }
}
