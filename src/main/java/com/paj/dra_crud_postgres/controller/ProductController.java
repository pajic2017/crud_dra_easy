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

   @GetMapping("/shows/{id}")
   public Product showOneProduct(@PathVariable("id") int id) throws Exception {
        log.info("Product with Id: "+id);
        return service.lookOneProduct(id);
   }

   @DeleteMapping("/delete/{id}")
   public void deleteProductData(@PathVariable("id") int id){
        log.info("Deleting product: "+id);
        service.deleteOneProduct(id);
   }

   @PutMapping("/update/{id}")
   public Product updateExistingProduct(@PathVariable("id")int id, @RequestBody Product product){
        log.info("Updating product with id: "+id);
        return service.editProduct(id,product);
   }

   // do not working properly
//   @GetMapping("showbyprice/{price}")
//   public Product showOneProductByPrice(@PathVariable("price") double price){
//        log.info("Product with price: "+price);
//        return new Product();
//
//   }
}
