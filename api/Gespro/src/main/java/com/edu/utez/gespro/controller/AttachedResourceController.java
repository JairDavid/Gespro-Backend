package com.edu.utez.gespro.controller;

import com.edu.utez.gespro.entity.AttachedResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.edu.utez.gespro.service.AttachedResourceService;

import java.util.List;

@RestController
@RequestMapping("/adscrito")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class AttachedResourceController {

    @Autowired
    private AttachedResourceService attachedResourceService;

    @GetMapping("/consultarTodos")
    public List<AttachedResource> listAll(){
        return attachedResourceService.getAll();
    }

    @GetMapping("/todos")
    public List<AttachedResource> all(){
        return attachedResourceService.getAllPersonalized();
    }

    @GetMapping("/consultaUnica/{id}")
    public AttachedResource edit(@PathVariable("id") long id){
        return attachedResourceService.getOne(id);
    }

    @GetMapping("/consultaIdEmpleado/{id}")
    public List<AttachedResource> getByIdEmp(@PathVariable("id") long id){
        return attachedResourceService.getByIdEmp(id);
    }

    @PostMapping("/guardar")
    public AttachedResource save(@RequestBody AttachedResource attachedResource){
        return attachedResourceService.save(attachedResource);
    }

    @PutMapping("/actualizar/{id}")
    public AttachedResource update(@RequestBody AttachedResource nuevo, @PathVariable("id") long id){
        return attachedResourceService.update(nuevo, id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable("id") long id){
        attachedResourceService.remove(id);
    }
}
