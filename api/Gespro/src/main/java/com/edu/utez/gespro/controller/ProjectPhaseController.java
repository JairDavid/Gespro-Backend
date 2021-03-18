package com.edu.utez.gespro.controller;

import com.edu.utez.gespro.entity.TypePhase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.edu.utez.gespro.service.ProjectPhaseService;


import java.util.List;

@RestController
@RequestMapping("/faseTipo")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class ProjectPhaseController {
    @Autowired
    private ProjectPhaseService projectPhaseService;

    @GetMapping("/consultarTodos")
    public List<TypePhase> listAll(){
        return projectPhaseService.getAll();
    }

    @GetMapping("/consultaUnica/{id}")
    public TypePhase edit(@PathVariable("id") long id){
        return projectPhaseService.getOne(id);
    }

    @PostMapping("/guardar")
    public TypePhase save(@RequestBody TypePhase typePhase){
        return projectPhaseService.saveOrUpdate(typePhase);
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
