package com.paj.dra_crud_postgres.controller;

import com.paj.dra_crud_postgres.DraCrudPostgresApplication;
import com.paj.dra_crud_postgres.entity.Product;
import com.paj.dra_crud_postgres.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class ProductController {
    //variables
    //methods

    private static final java.util.logging.Logger log= Logger.getLogger(ProductController.class.getName());

   @Autowired
    private ProductService service;

    @GetMapping("/start")
   public String startPoint(){
       log.info("Inside startPoint() method...");
       return "Strating of my Application";

   }


   @PostMapping("/create")
   public Product createProduct(@RequestBody Product product){
       log.info("Our Product: "+product);
       return (Product) service.makeNewProduct(product);

   }

    // http://localhost:7788/api/shows
   @GetMapping("/shows")
   List<Product> showProducts(){
       log.info("All Products..... ");
       return service.showAllProducts();

   }
}
