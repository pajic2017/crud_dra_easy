package com.paj.dra_crud_postgres.controller;

import com.paj.dra_crud_postgres.entity.Product;
import com.paj.dra_crud_postgres.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    //variables
    //methods

   @Autowired
    private ProductService service;

   @PostMapping("/create")
   public Product createProduct(@RequestBody Product product){
       return (Product) service.makeNewProduct(product);

   }

   @GetMapping("/shows")
   List<Product> showProducts(){
       return service.showAllProducts();

   }
}
