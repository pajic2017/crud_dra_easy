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
    private ProductRepo productRepo;

    @Override
    public Product makeNewProduct(Product product){
        return(Product) productRepo.save(product);

    }

    @Override
    public List<Product> showAllProducts(){
        return productRepo.findAll();
    }

    @Override
    public Product lookOneProduct(int id) throws Exception {
        Product existingProduct=productRepo.findById(id).orElse(null);
        if (existingProduct !=null){
            return existingProduct;
        }else{
            throw new NullPointerException("Product not found with id: "+id);
        }

    }


    @Override
    public void deleteOneProduct(int id){
        productRepo.deleteById(id);
    }

    @Override
    public Product editProduct(int id, Product product){
        Product existingProduct=productRepo.findById(id).orElse(null);
        if(existingProduct==null){
            throw new NullPointerException("Product for edit not found with id: "+id);
        }
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        productRepo.save(existingProduct);
        return existingProduct;
    }

    @Override
    public Product lookUsingPrice(double price){
        return null;

    }
}
