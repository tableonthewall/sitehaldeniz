package com.denizhal.site.service;

import com.denizhal.site.model.Product;
import com.denizhal.site.repositories.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return productsRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        productsRepository.deleteById(id);
    }


}
