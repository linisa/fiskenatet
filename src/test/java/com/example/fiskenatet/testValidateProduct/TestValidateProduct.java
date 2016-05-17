package com.example.fiskenatet.testValidateProduct;

import com.example.fiskenatet.models.ProductModel;
import com.example.fiskenatet.services.ProductService;
import junit.framework.TestCase;

/**
 * Created by Linus on 2016-05-17.
 */
public class TestValidateProduct extends TestCase{

    ProductService productService;
    ProductModel productModel;

    public void setUp() throws Exception{
        super.setUp();
        productService = new ProductService();
        productModel = new ProductModel();
        productModel.setTitle("Torsk");
        productModel.setDescription("Jete godd");
        productModel.setCategory("Lax");
        productModel.setImage("http://www.gabrielalares.com/wp-content/uploads/2013/12/torsk500.jpg");
        productModel.setStartPrice(1);
        productModel.setBuyNowPrice(2);
    }
    public void testValidateProductInput(){
        assertEquals("OK", productService.validateProductInput(productModel));
    }
}
