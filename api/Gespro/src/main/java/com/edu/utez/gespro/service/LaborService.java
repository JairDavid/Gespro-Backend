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

    public Labor save(Labor labor) {
        return laborRespository.save(labor);
    }

    public Labor update(Labor nuevo, long id) {
        Labor labor = getOne(id);
        labor.setName(nuevo.getName());
        return laborRespository.save(labor);
    }

    public void remove(long id) {
        laborRespository.deleteById(id);
    }

    public Labor searchByName(String name){
        return laborRespository.searchByName(name);
    }

    public boolean getName(String name){
        try{
            Labor dato=laborRespository.searchByName(name);
            if(dato.getName()!=null|| dato.getName()!=""){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }
}
