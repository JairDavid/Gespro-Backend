package com.edu.utez.gespro.service;


import com.edu.utez.gespro.entity.Deliverable;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.utez.gespro.repository.DeliverableRepository;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class DeliverableService {
    @Autowired
    private DeliverableRepository deliverableRepository;

    public List<Deliverable> getAll(){
        return deliverableRepository.findAll();
    }

    public Deliverable getOne(long id) {
        return deliverableRepository.findById(id).get();
    }


    public Deliverable save(MultipartFile file, String json) {
        Deliverable deliverable = null;
        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            deliverable = new ObjectMapper().readValue(json, Deliverable.class);
            deliverable.setOriginalName(fileName);
            deliverable.setFile(file.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
        return deliverableRepository.save(deliverable);
    }

    public Deliverable update(MultipartFile file, long id, String json){
        Deliverable deliverable = getOne(id);
        Deliverable nuevo = null;
        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            nuevo = new ObjectMapper().readValue(json, Deliverable.class);
            deliverable.setName(nuevo.getName());
            deliverable.setOriginalName(fileName);
            deliverable.setFile(file.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
        return deliverableRepository.save(deliverable);
    }

    public Deliverable updateName(long id, String name){
        Deliverable deliverable = getOne(id);
        try {
            deliverable.setName(name);
        }catch (Exception e){
            e.printStackTrace();
        }
        return deliverableRepository.save(deliverable);
    }


    public void remove(long id) {
        deliverableRepository.deleteById(id);
    }
}
