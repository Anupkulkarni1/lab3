package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class DeleteFileController {
    @RequestMapping(value = "/delete", headers="Accept=application/json", method = POST)
    public String deletefile(@RequestBody String filePath, HttpSession session) {
        Iterable<file> fileName = this.fservice.getData(session.getAttribute("name").toString());
        Iterator<file> fileIterator = fileName.iterator();
        while(fileIterator.hasNext()) {
            file getFile = (file)fileIterator.next();
            String filePathnew= getFile.getPath();
            if (filePathnew.equals(filePath)) {
                this.fservice.deleteFile(filePathnew);
            }
        }

        return "201";
    }
}
