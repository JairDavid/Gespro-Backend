package com.edu.utez.gespro.service;

import com.edu.utez.gespro.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.utez.gespro.repository.RoleRepository;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public List<Role> getAll(){
        return roleRepository.findAll();
    }

    public Role getOne(long id) {
        return roleRepository.findById(id).get();
    }

    public Role saveOrUpdate(Role role) {
        return roleRepository.save(role);
    }

    public void remove(long id) {
        roleRepository.deleteById(id);
    }
}
