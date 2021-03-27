package com.edu.utez.gespro.service;

import com.edu.utez.gespro.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.utez.gespro.repository.TypeRepository;

import java.util.List;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;

    public List<Type> getAll(){
        return typeRepository.findAll();
    }

    public Type getOne(long id) {
        return typeRepository.findById(id).get();
    }

    public Type save(Type type) {
        return typeRepository.save(type);
    }

    public Type update(Type nuevo, long id) {
        Type tipo = getOne(id);
        tipo.setName(nuevo.getName());
        return typeRepository.save(tipo);
    }

    public void remove(long id) {
        typeRepository.deleteById(id);
    }
}
