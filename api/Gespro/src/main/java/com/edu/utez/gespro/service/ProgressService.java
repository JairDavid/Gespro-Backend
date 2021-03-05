package com.edu.utez.gespro.service;

import com.edu.utez.gespro.entity.Progress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.edu.utez.gespro.repository.ProgressRespository;

import java.io.IOException;
import java.util.List;

@Service
public class ProgressService {
    @Autowired
    private ProgressRespository progressRespository;

    public List<Progress> getAll(){
        return progressRespository.findAll();
    }

    public Progress getOne(long id) {
        return progressRespository.findById(id).get();
    }

    public Progress saveOrUpdate(Progress progress, MultipartFile file) throws IOException {
        progress.setFile(file.getBytes());
        return progressRespository.save(progress);
    }

    public void remove(long id) {
        progressRespository.deleteById(id);
    }
}
