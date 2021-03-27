package com.edu.utez.gespro.service;

import com.edu.utez.gespro.entity.Progress;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
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
    public List<Progress> getAllTrue(){
        return progressRespository.searchAllTrue();
    }

    public Progress getOne(long id) {
        return progressRespository.findById(id).get();
    }

    public Progress save(MultipartFile file, String json) throws IOException {
        Progress progress = null;
        try {
        	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            progress = new ObjectMapper().readValue(json, Progress.class);
            progress.setOriginalName(fileName);
            progress.setFile(file.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
        progress.setFile(file.getBytes());
        return progressRespository.save(progress);
    }

    public Progress update(MultipartFile file, String json, long id){
        Progress progress = getOne(id);
        Progress nuevo = null;
        try {
            nuevo = new ObjectMapper().readValue(json, Progress.class);
            progress.setDescription(nuevo.getDescription());
            progress.setFile(file.getBytes());
            progress.setFinish(nuevo.isFinish());
        }catch (Exception e){
            e.printStackTrace();
        }
        return progressRespository.save(progress);
    }

    public void remove(long id) {
        progressRespository.deleteById(id);
    }

    public List<Progress> searchByIdProject(long id){
        return progressRespository.searchByIdProject(id);
    }
}
