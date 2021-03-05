package com.edu.utez.gespro.service;

import com.edu.utez.gespro.entity.Labor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.utez.gespro.repository.LaborRespository;

import java.util.List;

@Service
public class LaborService {
    @Autowired
    private LaborRespository laborRespository;


    public List<Labor> getAll(){
        return laborRespository.findAll();
    }

    public Labor getOne(long id) {
        return laborRespository.findById(id).get();
    }

    public Labor saveOrUpdate(Labor labor) {
        return laborRespository.save(labor);
    }

    public void remove(long id) {
        laborRespository.deleteById(id);
    }
}
