package com.edu.utez.gespro.controller;

import com.edu.utez.gespro.entity.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.edu.utez.gespro.service.EmployeService;

import java.util.List;

@RestController
@RequestMapping("/empleado")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class EmployeController {

    @Autowired
    private EmployeService employeService;

    @GetMapping("/consultarTodos")
    public List<Employe> listAll(){
        return employeService.getAll();
    }

    @GetMapping("/rolEmpleado")
    public List<Employe> listAllEmploye(){
        return employeService.getAllRolEmploye();
    }

    @GetMapping("/consultaUnica/{id}")
    public Employe edit(@PathVariable("id") long id){
        return employeService.getOne(id);
    }

    @PostMapping("/guardar")
    public Employe save(@RequestBody Employe employe){
        return employeService.save(employe);
    }

    @PutMapping("/actualizar/{id}")
    public Employe update(@RequestBody Employe nuevo, @PathVariable("id") long id){
        return employeService.update(nuevo, id);
    }


    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable("id") long id){
        employeService.remove(id);
    }

    @GetMapping("/correo/{email}")
    public Employe byEmail(@PathVariable("email") String correo){
         return employeService.getByEmail(correo);
    }

    @GetMapping("/consultaCurp/{curp}")
    public Employe byCurp(@PathVariable("curp")String curp){
        System.out.println("AQUI ESTOY");
        return employeService.getByCurp(curp);
    }
}
