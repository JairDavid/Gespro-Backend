package com.edu.utez.gespro.service;

import com.edu.utez.gespro.entity.DeliverableAssigment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.utez.gespro.repository.DeliverableAssigmentRespository;

import java.util.List;

@Service
public class DeliverableAssigmentService {
    @Autowired
    private DeliverableAssigmentRespository deliverableAssigmentRespository;

    public List<DeliverableAssigment> getAll(){
        return deliverableAssigmentRespository.findAll();
    }

    public DeliverableAssigment getOne(long id) {
        return deliverableAssigmentRespository.findById(id).get();
    }
    
    public List<DeliverableAssigment> getAllDeliverable(long id) {
        return deliverableAssigmentRespository.selectAllDeliverableAssigment(id);
    }

    public DeliverableAssigment saveOrUpdate(DeliverableAssigment deliverableAssigment) {
        return deliverableAssigmentRespository.save(deliverableAssigment);
    }

    public void remove(long id) {
        deliverableAssigmentRespository.deleteById(id);
    }


}
