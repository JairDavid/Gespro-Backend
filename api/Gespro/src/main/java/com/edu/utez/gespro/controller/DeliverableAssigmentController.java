package com.edu.utez.gespro.controller;

import com.edu.utez.gespro.entity.DeliverableAssigment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.edu.utez.gespro.service.DeliverableAssigmentService;

import java.util.List;
@RestController
@RequestMapping("/asignarEntregable")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class DeliverableAssigmentController {

    @Autowired
    private DeliverableAssigmentService deliverableAssigmentService;

    @GetMapping("/consultarTodos")
    public List<DeliverableAssigment> listAll(){
        return deliverableAssigmentService.getAll();
    }

    @GetMapping("/consultaUnica/{id}")
    public DeliverableAssigment edit(@PathVariable("id") long id){
        return deliverableAssigmentService.getOne(id);
    }

    @PostMapping("/guardar")
    public DeliverableAssigment save(@RequestBody DeliverableAssigment deliverableAssigment){
        return deliverableAssigmentService.saveOrUpdate(deliverableAssigment);
    }
    
    @GetMapping("/faseProyecto/{id}")
    public List<DeliverableAssigment>  getOne(@PathVariable("id") long id){
        return deliverableAssigmentService.getAllDeliverable(id);
    }

   /* @PutMapping("/actualizar/{id}")
    public DeliverableAssigment update(@RequestBody DeliverableAssigment nuevo, @PathVariable("id") long id){
        DeliverableAssigment deliverableAssigment = deliverableAssigmentService.getOne(id);
        deliverableAssigment.setDeliverable(nuevo.getDeliverable());
        deliverableAssigment.setProjectPhase(nuevo.getProjectPhase());
        return deliverableAssigmentService.saveOrUpdate(deliverableAssigment);
    }
    */

    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable("id") long id){
        deliverableAssigmentService.remove(id);
    }

}
