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
        return employeService.saveOrUpdate(employe);
    }

    @PutMapping("/actualizar/{id}")
    public Employe update(@RequestBody Employe nuevo, @PathVariable("id") long id){
        Employe empleado = employeService.getOne(id);
        empleado.setFirstName(nuevo.getFirstName());
        empleado.setLastName(nuevo.getLastName());
        empleado.setAdress(nuevo.getAdress());
        empleado.setBirthDate(nuevo.getBirthDate());
        empleado.setPhoneNumber(nuevo.getPhoneNumber());
        empleado.setCurp(nuevo.getCurp());
        empleado.setPassword(nuevo.getPassword());
        empleado.setStatus(nuevo.isStatus());
        return employeService.saveOrUpdate(empleado);
    }

    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable("id") long id){
        employeService.remove(id);
    }

    @GetMapping("/correo/{email}")
    public Employe byEmail(@PathVariable("email") String correo){
        System.out.println(correo);
         return employeService.getByEmail(correo);
    }
}
