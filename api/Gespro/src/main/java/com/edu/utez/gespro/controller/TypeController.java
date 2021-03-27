package com.edu.utez.gespro.controller;



import com.edu.utez.gespro.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.edu.utez.gespro.service.TypeService;

import java.util.List;

@RestController
@RequestMapping("/tipo")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("/consultarTodos")
    public List<Type> listAll(){
        return typeService.getAll();
    }

    @GetMapping("/consultaUnica/{id}")
    public Type edit(@PathVariable("id") long id){
        return typeService.getOne(id);
    }

    @PostMapping("/guardar")
    public Type save(@RequestBody Type nuevo){
        return typeService.save(nuevo);
    }

    @PutMapping("/actualizar/{id}")
    public Type update(@RequestBody Type nuevo,@PathVariable("id") long id){
        return typeService.update(nuevo, id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable("id") long id){
        typeService.remove(id);
    }
}
