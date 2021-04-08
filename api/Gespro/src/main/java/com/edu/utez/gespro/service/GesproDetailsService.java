package com.edu.utez.gespro.service;

import com.edu.utez.gespro.entity.Employe;
import com.edu.utez.gespro.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class GesproDetailsService implements UserDetailsService {

    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Employe emp = employeRepository.searchByEmail(s);
        if (emp==null)
            throw new UsernameNotFoundException("User not found by name: " + s);
        return new User(emp.getEmail(), "{noop}" + emp.getPassword(), new ArrayList<>());
    }

}

