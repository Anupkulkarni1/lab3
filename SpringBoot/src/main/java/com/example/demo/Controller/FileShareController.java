package com.example.demo.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class FileShareController {

    @RequestMapping(value = "/sharefile", headers="Accept=application/json", method = POST)
    public ResponseEntity<?> sharefile(@RequestBody String fileName, HttpSession session) {
        fileName = fileName.substring(1, fileName.length() - 1);
        String[] dataFromFile = fileName.split("&");
        String path = dataFromFile[0];
        String otheruser = dataFromFile[1];
        String email = session.getAttribute("name").toString();
        Iterable<file> fileName1 = this.fservice.getData(session.getAttribute("name").toString());
        Iterator<file> fileName2 = fileName1.iterator();
        file FileShare = new file();
        FileShare.setStar("No");
        FileShare.setIsdirectory("No");
        FileShare.setEmail(otheruser);
        FileShare.setDeletefile("No");
        FileShare.setPath(path);
        this.fservice.save(FileShare);
        return new ResponseEntity((MultiValueMap)null, HttpStatus.CREATED);
    }
}



