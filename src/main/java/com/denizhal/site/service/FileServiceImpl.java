package com.denizhal.site.service;

import com.denizhal.site.exception.FileNotFoundException;
import com.denizhal.site.model.Product;
import com.denizhal.site.repositories.ProductsRepository;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Transactional
public class FileServiceImpl implements FileService {
    private final Path root = Paths.get("src/main/uploads");
    private final ProductsRepository productsRepository;

    public FileServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public void uploadFile(MultipartFile file, Path path) throws IOException {
        System.out.println(root);

        try {
            System.out.println("path.toString: "+path.toString());
            System.out.println("path.toURİ:"+path.toUri());
            System.out.println("path. resolve:"+path.resolve(file.getOriginalFilename()).toString());
            Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename()));
        } catch (IOException e) {
            throw new IOException("Dosya yüklenemiyor " + e.getMessage());
        }
    }

    @Override
    public Resource loadFileAsResource(String filename) {
        try {
            Path demopath = Paths.get("src/main/uploads/app/");
            Product product=productsRepository.findFirstByOrderByIdDesc();
            String fileName=product.getApp_link();
            int i=fileName.lastIndexOf('/');
            String newFileName=fileName.substring(i);

            Path fileStorageLocation=Paths.get(demopath+newFileName).toAbsolutePath().normalize();
            Path filePath = fileStorageLocation.resolve(newFileName).normalize();
            System.out.println(fileStorageLocation.toString());
            Resource resource = new UrlResource(fileStorageLocation.toUri());
            System.out.println(resource.getURI());
            if(resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found " + filename);
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found " + filename);
        } catch (IOException e) {
            throw new FileNotFoundException("File not found " + filename);
        }
    }
}
