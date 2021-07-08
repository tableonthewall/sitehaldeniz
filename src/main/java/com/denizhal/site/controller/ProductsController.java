package com.denizhal.site.controller;

import com.denizhal.site.model.Product;
import com.denizhal.site.service.FileService;
import com.denizhal.site.service.ProductsService;
import com.denizhal.site.service.ProposeService;
import com.denizhal.site.xmlConnetion.GetVersion;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/admin/products")
public class ProductsController {
    private final ProductsService productsService;
    private final FileService fileService;
    private final ProposeService proposeService;
    private final GetVersion getVersion;

    public ProductsController(ProductsService productsService, FileService fileService, ProposeService proposeService) {
        this.productsService = productsService;
        this.fileService = fileService;
        this.proposeService = proposeService;
        GetVersion getVersion=null;
        try{
            getVersion=new GetVersion();
        }catch (JAXBException j){
            System.out.println(j.getMessage());
        }catch (MalformedURLException m){
            System.out.println(m.getMessage());
        }
        this.getVersion=getVersion;
    }

    /**
     * listProducts
     * Request mapping de belirtilen yolla bu method çalışıyor.
     * ürünler bağlantısına tıklandığında geriye cevap olarak ürünlerin listesi gönderiliyor.
     * @param model
     * @return
     */
    @GetMapping
    public String listProducts(Model model){
        List<Product> productList=productsService.getProducts();
        for(int i=0;i<productList.size();i++){
            productList.get(i).setVersion(getVersion.getVersion());
        }
        model.addAttribute("products",productList);
        return "products/listProducts";
    }

    @GetMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("product",new Product());
        return "products/newProduct";
    }

    @GetMapping("/{id}/show")
    @Transactional //new update
    public String showProduct(@PathVariable int id,Model model){
        Product product=productsService.getProduct(id);
        product.setProposes(proposeService.getProposesByProductId(product.getId()));
        model.addAttribute("product",product);
        return "products/productDetails";
    }

    @GetMapping("/{id}/update")
    public String updateProduct(@PathVariable int id,Model model){
        model.addAttribute(productsService.getProduct(id));
        return "products/updateProduct";
    }

    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable int id)
    {
        productsService.delete(id);
        return "/admin/products";
    }

    @PostMapping("/update")
    @Transactional //new update
    public String handlingUpdate(@RequestParam MultipartFile demolink, @RequestParam MultipartFile applink,
                                 @ModelAttribute Product product){
        if(!demolink.isEmpty()){
            Path demopath = Paths.get("src/main/uploads/demo");
            try {
                fileService.uploadFile(demolink,demopath);

            }catch (Exception e){
                e.printStackTrace();
            }
            product.setDemo_link("/src/main/uploads/demo/" +demolink.getOriginalFilename());
        }
        if(!applink.isEmpty()){
            Path apppath = Paths.get("src/main/uploads/app");
            try {
                fileService.uploadFile(applink,apppath);

            }catch (Exception e){
                e.printStackTrace();
            }
            product.setApp_link("/src/main/uploads/app/" +applink.getOriginalFilename());
        }
        product.setProposes(proposeService.getProposesByProductId(product.getId()));
        productsService.save(product);
        return "redirect:/admin/products";

    }
    @PostMapping("/new")
    @Transactional
    public String handlingNewProduct(@RequestParam MultipartFile demolink, @RequestParam MultipartFile applink,
                                     @ModelAttribute Product product){
        Path demopath = Paths.get("src/main/uploads/demo");
        Path apppath = Paths.get("src/main/uploads/app");
        try {
            fileService.uploadFile(demolink,demopath);

        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            fileService.uploadFile(applink,apppath);

        }catch (Exception e){
            e.printStackTrace();
        }

        product.setDemo_link("/src/main/uploads/demo/" +demolink.getOriginalFilename());
        product.setApp_link("/src/main/uploads/app/" +applink.getOriginalFilename());
        productsService.save(product);
        return "redirect:/admin/products";
    }
}
