package com.denizhal.site.controller;

import com.denizhal.site.model.Product;
import com.denizhal.site.model.Propose;
import com.denizhal.site.service.ProductsService;
import com.denizhal.site.service.ProposeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/propose")
public class ProposeContoller {
    private final ProductsService productsService;
    private final ProposeService proposeService;

    public ProposeContoller(ProductsService productsService, ProposeService proposeService) {
        this.productsService = productsService;
        this.proposeService = proposeService;
    }
    //Yeni teklif yapmak için sayfaya
    @GetMapping
    public String propose(Model model){
        model.addAttribute("propose",new Propose());
        return "propose";
    }
    //Bütün teklifler
    @GetMapping("/listAll")
    public String listAll(Model model){
        model.addAttribute("proposes",proposeService.getPropose());
        return "proposes/listAll";
    }
    //bir üründen gelen tekliflerin tamamını göstermek için::
    @GetMapping("/{id}/list")
    public String listByProductId(@PathVariable int id,Model model){
        model.addAttribute("proposes",proposeService.getProposesByProductId(id));
        return "proposes/listAll";
    }

    @GetMapping("/{productid}/delete/{proposeid}")
    public String deletePropose(@PathVariable int productid,@PathVariable int proposeid){
        proposeService.delete(proposeid);
        return "redirect:/propose/"+productid+"/list";
    }

    //yeni teklifi kaydetme
    @PostMapping("/yeniteklif")
    public String yeniTeklif(@Valid @ModelAttribute("propose") Propose propose ,BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "propose";
        }
        propose.setSavedate(LocalDate.now());
        propose.setProduct(productsService.getLastProduct());
        proposeService.savePropose(propose);
        return "redirect:/propose?success";
    }

}
