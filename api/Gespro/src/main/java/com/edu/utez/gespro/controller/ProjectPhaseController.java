package com.edu.utez.gespro.controller;

import com.edu.utez.gespro.entity.ProjectPhase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.edu.utez.gespro.service.ProjectPhaseService;


import java.util.List;

@RestController
@RequestMapping("/faseProyecto")
public class ProjectPhaseController {
    @Autowired
    private ProjectPhaseService projectPhaseService;

    @GetMapping("/consultarTodos")
    public List<ProjectPhase> listAll(){
        return projectPhaseService.getAll();
    }

    @GetMapping("/consultaUnica/{id}")
    public ProjectPhase edit(@PathVariable("id") long id){
        return projectPhaseService.getOne(id);
    }

    @PostMapping("/guardar")
    public ProjectPhase save(@RequestBody ProjectPhase projectPhase){
        return projectPhaseService.saveOrUpdate(projectPhase);
    }

    /*
    @PutMapping("/actualizar")
    public ProjectPhase update(@RequestBody ProjectPhase projectPhase){

        return projectPhaseService.saveOrUpdate(projectPhase);
    }*/

    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable("id") long id){
        projectPhaseService.remove(id);
    }
}
