package com.edu.utez.gespro.controller;


import com.edu.utez.gespro.entity.Deliverable;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.edu.utez.gespro.service.DeliverableService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/entregable")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class DeliverableController {
    @Autowired
    private DeliverableService deliverableService;

    @GetMapping("/consultarTodos")
    public List<Deliverable> listAll(){
        return deliverableService.getAll();
    }

    @GetMapping("/consultaUnica/{id}")
    public Deliverable edit(@PathVariable("id") long id){
        return deliverableService.getOne(id);
    }

    @PostMapping("/guardar")
    public Deliverable save(@RequestParam("archivo") MultipartFile file, String json) throws IOException {
        Deliverable deliverable = null;
        try {
            deliverable = new ObjectMapper().readValue(json, Deliverable.class);
            deliverable.setFile(file.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
        return deliverableService.saveOrUpdate(deliverable);
    }

    @PutMapping("/actualizar/{id}")
    public Deliverable update(@RequestParam("archivo") MultipartFile file, @PathVariable("id") long id, String json) throws IOException {
        Deliverable deliverable = deliverableService.getOne(id);
        Deliverable nuevo = null;
        try {
            nuevo = new ObjectMapper().readValue(json, Deliverable.class);
            deliverable.setName(nuevo.getName());
            deliverable.setFile(file.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
        return deliverableService.saveOrUpdate(deliverable);
    }

    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable("id") long id){
        deliverableService.remove(id);
    }
}
