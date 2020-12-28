package com.denizhal.site.service;

import com.denizhal.site.model.Product;

import java.util.List;

public interface ProductsService {
    List<Product> getProducts();
    void save(Product product);
    Product getLastProduct();
    Product getProduct(Integer id);
    void delete(Integer id);
}
