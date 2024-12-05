package com.kh.wegrid.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUploader {

    public static String save(MultipartFile f , String path) throws IOException {
        if (!f.isEmpty()) {
            String originalFilename = f.getOriginalFilename();
            String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
            String randomStr = UUID.randomUUID().toString();
            String changeName = randomStr + ext;
            File targetFile = new File(path + changeName);
            f.transferTo(targetFile);
            return changeName;
        }
        return null;
    }

}
