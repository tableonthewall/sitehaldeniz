package com.denizhal.site.controller;

import com.denizhal.site.service.ProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/download")
public class DownloadController {

    private final ProductsService productsService;

    public DownloadController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/demo")
    public void getDemo(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //linux
        Path demopath = Paths.get("src/main/uploads/demo/");
        String filename=productsService.getLastProduct().getDemo_link();
        //last indexof linux a göre / şekline getirildi
        //System.out.println(filename);
        int i=filename.lastIndexOf("/");
        String newFileName=filename.substring(i);
        //System.out.println(newFileName);
        File file=new File(demopath+newFileName);
        //System.out.println(file.getAbsoluteFile());

        if(file.exists()){
            //System.out.println("dosya bulundu");
            String mimeType= URLConnection.guessContentTypeFromName(file.getName());
            if(mimeType==null){
                mimeType="application/octet-stream";
            }
            response.setContentType(mimeType);
            response.setHeader("Content-Disposition",String.format("attachment;filename=\""+file.getName()+"\""));

            response.setContentLength((int) file.length());
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

            FileCopyUtils.copy(inputStream, response.getOutputStream());
        }
    }


}
