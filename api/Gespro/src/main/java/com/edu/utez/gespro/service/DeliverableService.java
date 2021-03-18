package com.edu.utez.gespro.service;


import com.edu.utez.gespro.entity.Deliverable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.utez.gespro.repository.DeliverableRepository;

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


    public Deliverable saveOrUpdate(Deliverable deliverable) {
        return deliverableRepository.save(deliverable);
    }

    public void remove(long id) {
        deliverableRepository.deleteById(id);
    }
}
