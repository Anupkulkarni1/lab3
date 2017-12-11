package com.example.demo.utils;

import com.example.demo.Exception.fileException;
import com.example.demo.model.UploadModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUploadUtils {

    private final static String PATH_FODER = "src/main/resources/files/";

    public static UploadModel saveFiles(MultipartFile file, String desc) throws IOException {
        if(file.isEmpty()){
            throw new fileException("File is empty");
        }
        byte[] bytes = file.getBytes();
        Path path = Paths.get(PATH_FODER);

        if (!Files.exists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS})) {
            Files.createDirectories(path);
        }
        String fileType = "." + file.getContentType().split("/")[1];
        path = Paths.get(PATH_FODER + file.hashCode() + fileType);
        Files.write(path, bytes);
        UploadModel uploadModel = new UploadModel(file.getOriginalFilename(), file.getSize(), path.toString(), desc);
        return uploadModel;
    }
}
