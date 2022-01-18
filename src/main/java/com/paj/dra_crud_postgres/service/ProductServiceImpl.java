package com.paj.dra_crud_postgres.service;

import com.paj.dra_crud_postgres.entity.Product;
import com.paj.dra_crud_postgres.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    /*variable*/
    @Autowired
    private ProductRepo repo;

    @Override
    public Product makeNewProduct(Product product){
        return(Product) repo.save(product);

    }

    @Override
    public List<Product> showAllProducts(){
        return repo.findAll();

    }
}
