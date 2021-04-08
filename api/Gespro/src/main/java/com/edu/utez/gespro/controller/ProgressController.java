package com.edu.utez.gespro.controller;


import com.edu.utez.gespro.entity.Progress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
    
    @GetMapping("/terminado/{idproyecto}/{idasignacion}")
    public Progress finish(@PathVariable("idproyecto") long idP, @PathVariable("idasignacion") long idA){
        return progressService.searchFinish(idP, idA);
    }

    @GetMapping("/consultaUnica/{id}")
    public Progress edit(@PathVariable("id") long id) {
        return progressService.getOne(id);
    }

    @PostMapping("/guardar")
    public Progress save(@RequestParam("archivo") MultipartFile file, String json) throws IOException {
        return progressService.save(file, json);
    }

    @GetMapping("/descargar/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable("id")long id){
        Progress progress = progressService.getOne(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + progress.getOriginalName() + "\"")
                .body(progress.getFile());
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
