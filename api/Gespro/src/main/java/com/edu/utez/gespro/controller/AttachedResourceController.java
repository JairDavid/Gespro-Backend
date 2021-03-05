package com.edu.utez.gespro.controller;

import com.edu.utez.gespro.entity.AttachedResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.edu.utez.gespro.service.AttachedResourceService;

import java.util.List;

@RestController
@RequestMapping("/adscrito")
public class AttachedResourceController {

    @Autowired
    private AttachedResourceService attachedResourceService;

    @GetMapping("/consultarTodos")
    public List<AttachedResource> listAll(){
        return attachedResourceService.getAll();
    }

    @GetMapping("/consultaUnica/{id}")
    public AttachedResource edit(@PathVariable("id") long id){
        return attachedResourceService.getOne(id);
    }

    @PostMapping("/guardar")
    public AttachedResource save(@RequestBody AttachedResource attachedResource){
        return attachedResourceService.saveOrUpdate(attachedResource);
    }

    @PutMapping("/actualizar/{id}")
    public AttachedResource update(@RequestBody AttachedResource attachedResource, @PathVariable("id") long id){
        AttachedResource existente = attachedResourceService.getOne(id);
        existente.setLabor(attachedResource.getLabor());
        return attachedResourceService.saveOrUpdate(existente);
    }

    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable("id") long id){
        attachedResourceService.remove(id);
    }
}
