package com.edu.utez.gespro.controller;


import com.edu.utez.gespro.entity.Progress;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.edu.utez.gespro.service.ProgressService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/avance")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    @GetMapping("/consultarTodos")
    public List<Progress> listAll() {
        return progressService.getAll();
    }

    @GetMapping("/consultarTerminados")
    public List<Progress> listAllTrue() {
        return progressService.getAllTrue();
    }

    @GetMapping("/consultaUnica/{id}")
    public Progress edit(@PathVariable("id") long id) {
        return progressService.getOne(id);
    }

    @PostMapping("/guardar")
    public Progress save(@RequestParam("archivo") MultipartFile file, String json) throws IOException {
        return progressService.save(file, json);
    }

    @PutMapping("/actualizar/{id}")
    public Progress update(@RequestParam("archivo") MultipartFile file, String json, @PathVariable("id") long id) throws IOException {
        return progressService.update(file, json,id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable("id") long id) {
        progressService.remove(id);
    }

    @GetMapping("/buscarProyecto/{id}")
    public List<Progress> searchIdProject(@PathVariable("id") long id){
        return progressService.searchByIdProject(id);
    }
}
