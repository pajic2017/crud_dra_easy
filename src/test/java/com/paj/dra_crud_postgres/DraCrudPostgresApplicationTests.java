package com.paj.dra_crud_postgres;

import com.paj.dra_crud_postgres.controller.ProductController;
import com.paj.dra_crud_postgres.entity.Product;
import com.paj.dra_crud_postgres.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

}
