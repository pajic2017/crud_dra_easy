package com.paj.dra_crud_postgres.service;

import com.paj.dra_crud_postgres.DraCrudPostgresApplication;
import com.paj.dra_crud_postgres.entity.Product;
import com.paj.dra_crud_postgres.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ProductServiceImpl implements ProductService {

    private static final java.util.logging.Logger log= Logger.getLogger(ProductServiceImpl.class.getName());

    /*variable*/
    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product makeNewProduct(Product product){
        validateProduct(product);
        log.info("Creating a new product: "+product);
        return(Product) productRepo.save(product);

    }

    @Override
    public List<Product> showAllProducts(){
        log.info("Fetch all products: ");
        return productRepo.findAll();
    }

    @Override
    public Product lookOneProduct(int id) throws Exception {
        log.info("Fetch  product with id: "+id);
//        Product existingProduct=productRepo.findById(id).orElse(null);
//        if (existingProduct !=null){
//            return existingProduct;
//        }else{
//            throw new NullPointerException("Product not found with id: "+id);
//        }
        return productRepo.findById(id)
                .orElseThrow(() -> new Exception("Product not found with Id "+id));

    }


    @Override
    public void deleteOneProduct(int id) throws Exception {
        log.info("Delete  product with id: "+id);
        //productRepo.findById(id)
        if(!productRepo.existsById(id)){
            throw new Exception("Can not delete, because not exist Id: "+id);
        }
        productRepo.deleteById(id);
    }

    @Override
    public Product editProduct(int id, Product product) throws Exception {
        validateProduct(product);
        log.info("Edit product: "+product);
        Product existingProduct=productRepo.findById(id)
                .orElseThrow(() -> new Exception("Product edit not found with Id "+id));
//        if(existingProduct==null){
//            throw new NullPointerException("Product for edit not found with id: "+id);
//        }
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        productRepo.save(existingProduct);
        return existingProduct;
    }

    @Override
    public Product lookUsingPrice(double price) {
        log.info("Fetching product with price: "+price);
        return productRepo.findByPrice(price);
                //.orElseThrow(() -> new Exception("Product  not found with price "+price));
    }

    private void validateProduct(Product product){
        if(product.getName() == null || product.getName().isEmpty()){
            throw new IllegalArgumentException("Product name can not be null or empty");

        }

        if(product.getPrice() <=0){
            throw new IllegalArgumentException("Product price must be graeter then zero");
        }

        if(product.getQuantity()<0){
            throw new IllegalArgumentException("Quantity must be greater then zero");
        }

    }
}
