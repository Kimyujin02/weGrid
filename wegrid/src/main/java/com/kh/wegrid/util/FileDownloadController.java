package com.kh.wegrid.util;

import com.kh.wegrid.conf.PathInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

@RestController
public class FileDownloadController {

    @Autowired
    private PathInfo pathInfo; // PathInfo 클래스

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadFile(@RequestParam String fileName) throws IOException {
        // 파일이 저장된 경로
        Path path = Paths.get(pathInfo.getBoardAttachmentPath() + fileName);

        // 파일을 리소스로 변환
        Resource resource = new UrlResource(path.toUri());

        if (!resource.exists()) {
            throw new IOException("파일을 찾을 수 없습니다: " + fileName);
        }

        // HTTP 응답으로 파일을 전송
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }
}
