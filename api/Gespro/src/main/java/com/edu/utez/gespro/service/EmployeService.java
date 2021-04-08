package com.edu.utez.gespro.service;

import com.edu.utez.gespro.entity.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.utez.gespro.repository.EmployeRepository;

import java.util.List;

@Service
public class EmployeService {
    @Autowired
    private EmployeRepository employeRepository;


    public List<Employe> getAll(){
        return employeRepository.findAll();
    }

    public Employe getOne(long id) {
        return employeRepository.findById(id).get();
    }

    public Employe save(Employe employe) {
        employe.setPassword(employe.getEmail());
        return employeRepository.save(employe);
    }

    public Employe update(Employe nuevo, long id) {
        Employe empleado = getOne(id);
        empleado.setFullName(nuevo.getFullName());
        empleado.setAdress(nuevo.getAdress());
        empleado.setBirthDate(nuevo.getBirthDate());
        empleado.setPhoneNumber(nuevo.getPhoneNumber());
        empleado.setCurp(nuevo.getCurp());
        empleado.setPassword(nuevo.getPassword());
        empleado.setStatus(nuevo.isStatus());
        return employeRepository.save(empleado);
    }

    public void remove(long id) {
        employeRepository.deleteById(id);
    }

    public Employe getByEmail(String email){
        return employeRepository.searchByEmail(email);
    }

    public Employe getByCurp(String curp){
        return employeRepository.searchByCurp(curp);
    }

    public List<Employe> getAllRolEmploye(){
        return employeRepository.searchByRol();
    }
}
