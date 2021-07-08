package com.denizhal.site.controller;

import com.denizhal.site.service.ProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
@RequestMapping("/download")
public class DownloadController {

    private final ProductsService productsService;

    public DownloadController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/demo")
    public String getDemo(HttpServletRequest request,HttpServletResponse response) throws IOException {
        /**
         *
         * bu kısım bir dosyanın yüklenmesi ve gerektiğinde indirilmesi için yazıldı:
         */
//        //linux
//        Path demopath = Paths.get("src/main/uploads/demo/");
//        String filename=productsService.getLastProduct().getDemo_link();
//        //last indexof linux a göre / şekline getirildi
//        //System.out.println(filename);
//        int i=filename.lastIndexOf("/");
//        String newFileName=filename.substring(i);
//        //System.out.println(newFileName);
//        File file=new File(demopath+newFileName);
//        //System.out.println(file.getAbsoluteFile());
        final String FILE_URL="http://www.asesyazilim.com/update/halsetup/DenizHalSetup.exe";
        String home=System.getProperty("user.home");
        File downloadFile=new File(home+ "/Downloads/" + "DenizHalSetup"+".exe");
        URL file=null;
        try{
            file=new URL(FILE_URL);
            System.out.println(file.toString());
        }catch (IOException e){
            System.out.println("dosya bulunamadı");
        }


        try(
            ReadableByteChannel rbc= Channels.newChannel(new URL(FILE_URL).openStream());
            FileOutputStream fos=new FileOutputStream(downloadFile);
            FileChannel fileChannel=fos.getChannel()){

            fileChannel.transferFrom(rbc,0,Long.MAX_VALUE);



        }catch (IOException e){
            System.out.println("dosya bulunamadı...");
        }

//        try (BufferedInputStream in = new BufferedInputStream(new URL(FILE_URL).openStream());
//             FileOutputStream fileOutputStream = new FileOutputStream(downloadFile)) {
//            byte dataBuffer[] = new byte[1024];
//            int bytesRead;
//            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
//                fileOutputStream.write(dataBuffer, 0, bytesRead);
//            }
//        } catch (IOException e) {
//            // handle exception
//        }

//        try(InputStream in =new URL(FILE_URL).openStream();OutputStream out=response.getOutputStream()){
//
//            response.setContentType("application/vnd.microsoft.portable-executable");
//            response.setHeader("Content-Disposition",String.format("attachment;filename=\""+"HalDenizSetup.exe"+"\""));
//
//            //response.setContentLength((int) file.length());
//            byte[] buffer=new byte[1048];
//            int numBytes;
//            while((numBytes=in.read(buffer))>0){
//                out.write(buffer,0,1048);
//            }
//        }catch (IOException e){
//            System.out.println("dosya indirilemedi");
//        }

//        if(file.exists()){
//            //System.out.println("dosya bulundu");
//            String mimeType= URLConnection.guessContentTypeFromName(file.getName());
//            if(mimeType==null){
//                mimeType="application/octet-stream";
//            }
//            response.setContentType(mimeType);
//            response.setHeader("Content-Disposition",String.format("attachment;filename=\""+file.getName()+"\""));
//
//            response.setContentLength((int) file.length());
//            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
//
//            FileCopyUtils.copy(inputStream, response.getOutputStream());
//        }
        return "products";
    }


}
