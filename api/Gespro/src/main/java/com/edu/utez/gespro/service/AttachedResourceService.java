package com.edu.utez.gespro.service;

import com.edu.utez.gespro.entity.AttachedResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.utez.gespro.repository.AttachedResourceRepository;

import java.util.List;

@Service
public class AttachedResourceService {
    @Autowired
    private AttachedResourceRepository attachedResourceRepository;

    public List<AttachedResource> getAll(){
        return (List<AttachedResource>) attachedResourceRepository.findAll();
    }

    public List<AttachedResource> getAllPersonalized(){
        return attachedResourceRepository.searchAll();
    }

    public AttachedResource getOne(long id) {
        return attachedResourceRepository.findById(id).get();
    }

    public AttachedResource save(AttachedResource attachedResource) {
        return attachedResourceRepository.save(attachedResource);
    }

    public AttachedResource update(AttachedResource nuevo, long id){
        AttachedResource existente = getOne(id);
        existente.setLabor(nuevo.getLabor());
        return attachedResourceRepository.save(existente);
    }

    public void remove(long id) {
        attachedResourceRepository.deleteById(id);
    }

    public List<AttachedResource> getByIdEmp(long id){
        return attachedResourceRepository.searchByIdEmp(id);
    }
}
