package com.edu.utez.gespro.controller;


import com.edu.utez.gespro.entity.Phase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.edu.utez.gespro.service.PhaseService;

import java.util.List;

@RestController
@RequestMapping("/fase")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class PhaseController {

    @Autowired
    private PhaseService phaseService;

    @GetMapping("/consultarTodos")
    public List<Phase> listAll(){
        return phaseService.getAll();
    }

    @GetMapping("/consultaUnica/{id}")
    public Phase edit(@PathVariable("id") long id){
        return phaseService.getOne(id);
    }

    @PostMapping("/guardar")
    public Phase save(@RequestBody Phase phase){
        return phaseService.saveOrUpdate(phase);
    }

    @PutMapping("/actualizar/{id}")
    public Phase update(@RequestBody Phase nuevo, @PathVariable("id") long id){
        Phase phase = phaseService.getOne(id);
        phase.setName(nuevo.getName());
        return phaseService.saveOrUpdate(phase);
    }

    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable("id") long id){
        phaseService.remove(id);
    }
}
