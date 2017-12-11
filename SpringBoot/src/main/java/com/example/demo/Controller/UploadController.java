package com.example.demo.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.Exception.fileException;
import org.springframework.beans.factory.annotation.Autowired;


import java.io.IOException;
import java.util.List;

import com.example.demo.model.UploadModel;
import com.example.demo.service.UploadService;
import com.example.demo.utils.FileUploadUtils;

@RestController
public class UploadController {

    @Autowired
    UploadService us;

    @PostMapping(value = "/upload",produces = "application/json")
    public ResponseEntity upload(MultipartFile file,String message) {
        try
        {
            UploadModel um=FileUploadUtils.saveFiles(file,message);
            us.saveUploadModel(um);
        } catch (fileException e)
        {
            e.printStackTrace();
            return new ResponseEntity("file is empty",HttpStatus.OK);
        } catch (IOException e)
        {
            e.printStackTrace();
            return new ResponseEntity("oops error!  ",HttpStatus.OK);
        }
        return new ResponseEntity("Success", HttpStatus.OK);
    }
}
