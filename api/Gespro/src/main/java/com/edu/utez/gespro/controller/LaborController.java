package com.edu.utez.gespro.controller;

import com.edu.utez.gespro.entity.Labor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.edu.utez.gespro.service.LaborService;

import java.util.List;

@RestController
@RequestMapping("/puesto")
public class LaborController {
    @Autowired
    private LaborService laborService;

    @GetMapping("/consultarTodos")
    public List<Labor> listAll(){
        return laborService.getAll();
    }

    @GetMapping("/consultaUnica/{id}")
    public Labor edit(@PathVariable("id") long id){
        return laborService.getOne(id);
    }

    @PostMapping("/guardar")
    public Labor save(@RequestBody Labor labor){
        return laborService.saveOrUpdate(labor);
    }

    @PutMapping("/actualizar/{id}")
    public Labor update(@RequestBody Labor nuevo, @PathVariable("id") long id){
        Labor labor = laborService.getOne(id);
        labor.setName(nuevo.getName());
        return laborService.saveOrUpdate(labor);
    }

    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable("id") long id){
        laborService.remove(id);
    }
}
