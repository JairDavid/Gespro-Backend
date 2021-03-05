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

    public Employe saveOrUpdate(Employe employe) {
        return employeRepository.save(employe);
    }

    public void remove(long id) {
        employeRepository.deleteById(id);
    }

    public Employe getByEmail(String email){
        return employeRepository.searchByEmail(email);
    }
}
