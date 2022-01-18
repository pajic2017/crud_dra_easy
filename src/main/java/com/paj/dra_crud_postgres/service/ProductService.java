package com.paj.dra_crud_postgres.service;

import com.paj.dra_crud_postgres.entity.Product;

import java.util.List;

public interface ProductService {

    Product makeNewProduct(Product product);
    List<Product> showAllProducts();
}
