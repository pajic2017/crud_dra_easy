package com.paj.dra_crud_postgres;

import com.paj.dra_crud_postgres.controller.ProductController;
import com.paj.dra_crud_postgres.entity.Product;
import com.paj.dra_crud_postgres.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class DraCrudPostgresApplicationTests {

    //add mock
    @Mock
    ProductService service;

    // inject mock
    @InjectMocks
    ProductController productController;


    @Test
    void basicTest() {
        ProductController controlerInter=new ProductController();
        assertNotNull(controlerInter);
    }

    @Test
    void createProductTest() {
        // savedProduct
        Product savedProduct=new Product(10,"Michael", 50, 34.5);
        //reqProduct
        Product reqProduct=new Product(10,"Michael", 50, 34.5);

        // use mockito tool
        when(service.makeNewProduct(reqProduct)).thenReturn(savedProduct);
        //verify(service).makeNewProduct(reqProduct);


        // use inject mock in our class
        Product outputController=productController.createProduct(reqProduct);

        // assert that is all good
        assertNotNull(outputController);

        String actualResult=outputController.getName();
        String expectedResult="Michael";

        assertEquals(expectedResult, actualResult);

        // verify that mocck is touched
        verify(service).makeNewProduct(reqProduct);

    }

    @Test
    void showProductsTest() {

        ArrayList<Product> products=new ArrayList();
        Product prod1=new Product();
        Product prod2=new Product();
        Product prod3=new Product();
        products.add(prod1);
        products.add(prod2);
        products.add(prod3);

        // use when and return tool from mockito
        when(service.showAllProducts()).thenReturn(products);

        // use inject class
        List<Product> outputListController=productController.showProducts();

        // assert that object exist
        assertNotNull(outputListController);

        // assert equals size of products
        int actualSizeOfProducts=outputListController.size();
        int expectedSizeOfProducts=3;

        assertEquals(expectedSizeOfProducts, actualSizeOfProducts);


        // verify that our method touch mock object
        verify(service).showAllProducts();

    }

    // add more test here
    @Test
    void showOneProductTest() throws Exception {
        Product savedProduct=new Product();
        savedProduct.setId(100);

        when(service.lookOneProduct(100)).thenReturn(savedProduct);

        Product outputOnProductController=productController.showOneProduct(100);
        assertNotNull(outputOnProductController);

        int actualValueOfProduct=outputOnProductController.getId();
        int expectedValueOfProduct=100;

        assertEquals(expectedValueOfProduct,actualValueOfProduct);

        verify(service).lookOneProduct(100);

    }

    // ???
    @Test
    void updateExistingProductSuccessfullyUpdatesProductTest() throws Exception {
        Product existingProduct = new Product(1, "OldName", 10, 20.0);
        Product updatedProduct = new Product(1, "NewName", 15, 25.0);

        when(service.editProduct(1, updatedProduct)).thenReturn(updatedProduct);

        Product result = productController.updateExistingProduct(1, updatedProduct);

        assertNotNull(result);
        assertEquals("NewName", result.getName());
        assertEquals(15, result.getQuantity());
        assertEquals(25.0, result.getPrice());

        verify(service).editProduct(1, updatedProduct);
    }

    @Test
    void deleteProductDataTest() throws Exception {
        doNothing().when(service).deleteOneProduct(100);
    }



}
