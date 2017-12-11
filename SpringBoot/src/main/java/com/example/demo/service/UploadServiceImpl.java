package com.example.demo.service;

import com.example.demo.model.UploadModel;
import com.example.demo.model.UploadRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UploadServiceImpl implements UploadService {


    @Autowired
    UploadRepository uploadRepository;
    @Override
    public void saveUploadModel(UploadModel model) {
        uploadRepository.save(model);
    }
}
