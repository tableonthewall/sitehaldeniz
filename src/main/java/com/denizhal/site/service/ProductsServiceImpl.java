package com.denizhal.site.service;

import com.denizhal.site.model.Product;
import com.denizhal.site.repositories.ProductsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductsServiceImpl implements ProductsService {
    private final ProductsRepository productsRepository;

    public ProductsServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productsRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productsRepository.save(product);
    }

    @Override
    public Product getLastProduct() {
        return productsRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public Product getProduct(Integer id) {
        Optional<Product> optionalProduct=productsRepository.findById(id);
        if(!optionalProduct.isPresent()){
            log.error("Ürün bilgisi bulunamadı : "+id);
        }
        Product product=optionalProduct.get();
        return product;
    }

    @Override
    public void delete(Integer id) {
        productsRepository.deleteById(id);
    }


}
