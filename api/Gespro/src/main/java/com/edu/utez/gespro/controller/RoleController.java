package com.edu.utez.gespro.controller;


import com.edu.utez.gespro.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.edu.utez.gespro.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/rol")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/consultarTodos")
    public List<Role> listAll(){
        return roleService.getAll();
    }

    @GetMapping("/consultaUnica/{id}")
    public Role edit(@PathVariable("id") long id){
        return roleService.getOne(id);
    }

    @PostMapping("/guardar")
    public Role save(@RequestBody Role role){
        return roleService.saveOrUpdate(role);
    }

   /* @PutMapping("/actualizar")
    public Role update(@RequestBody Role role){
        return roleService.saveOrUpdate(role);
    }*/

    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable("id") long id){
        roleService.remove(id);
    }
}
