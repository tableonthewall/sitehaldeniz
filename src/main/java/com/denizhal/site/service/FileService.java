package com.denizhal.site.service;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;
import java.io.IOException;
import java.nio.file.Path;

public interface FileService {
    void uploadFile(MultipartFile file, Path path) throws IOException;
    Resource loadFileAsResource(String filename);
}
