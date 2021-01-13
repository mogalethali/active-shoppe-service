package com.active.shoppe.repository;

import com.active.shoppe.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductsRepository extends MongoRepository<Products, String> {

    List<Products> findAll();

}

