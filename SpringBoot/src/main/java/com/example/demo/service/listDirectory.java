package com.example.demo.service;
import org.apache.catalina.util.SystemPropertyReplacerListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class listDirectory {

    private final String directoryName;
    private List<String> l1;

    public listDirectory(String directoryName) {
        this.directoryName = directoryName;
        listFolders();
    }

    public void listFolders(){
        File directory = new File(this.directoryName);
        List<String> l1 = new ArrayList<String>();

        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isDirectory()){
                l1.add(file.getName());
            }
        }


        this.l1 = l1;
    }

    public List<String> getList() {
        return l1;
    }

}
