package com.example.demo.Controller;
import org.apache.catalina.util.SystemPropertyReplacerListener;

import java.io.File;
import java.util.ArrayList;

import com.example.demo.service.listDirectory;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin(origins = {"http://localhost:3000"}, maxAge = 6000)

@RestController
public class listDirectoryController {

    private final AtomicLong counter = new AtomicLong();
    @RequestMapping(value = "/listDirectories", headers="Accept=application/json", method = POST)
    public listDirectory ld(@RequestParam(value="dirName") String dirName) {

        System.out.println(dirName);

        return new listDirectory(dirName);
    }

}
