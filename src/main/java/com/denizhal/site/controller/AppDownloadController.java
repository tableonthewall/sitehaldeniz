package com.denizhal.site.controller;

import com.denizhal.site.service.FileService;
import com.denizhal.site.service.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.denizhal.site.model.Product;
import com.denizhal.site.repositories.ProductsRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.core.io.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;


@RestController
@RequestMapping(path="/app")
public class AppDownloadController {
    private final ProductsRepository productsRepository;
    private final ProductsService productsService;
    private final FileService fileService;

    private static final Logger logger = LoggerFactory.getLogger(AppDownloadController.class);


    public AppDownloadController(ProductsRepository productsRepository, ProductsService productsService, FileService fileService) {
        this.productsRepository = productsRepository;
        this.productsService = productsService;
        this.fileService = fileService;
    }

    @GetMapping(path = "/version",produces = "application/json")
    public String handleVersion(){
        Product product=productsRepository.findFirstByOrderByIdDesc();
        return product.getVersion();
    }

    @GetMapping(path = "/download" , produces = "application/json")
    public ResponseEntity<Resource> downloadFile(HttpServletRequest request) {
        System.out.println("istek geldi");

        String filename=productsRepository.findFirstByOrderByIdDesc().getApp_link();
        int i=filename.lastIndexOf('\\');
        String newFileName=filename.substring(i);
        Resource resource=null;
        try{
             resource= fileService.loadFileAsResource(newFileName);
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println(resource.getFilename());
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\""+resource.getFilename()+"\"")
                .body(resource);


    }



}
