package com.denizhal.site.repositories;

import com.denizhal.site.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product,Integer> {

    Product findFirstByOrderByIdDesc();
}
