package com.example.fiskenatet.UnitTestingMockito;

import com.example.fiskenatet.controllers.ProductController;
import com.example.fiskenatet.models.ProductModel;
import com.example.fiskenatet.repositories.ProductRepository;
import com.example.fiskenatet.services.ProductService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * Created by nordi_000 on 2016-05-02.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;
    @Mock
    private ProductService productService;
    @Mock
    private ProductRepository productRepository;

    private static final ProductModel torsk = new ProductBuilder().id(1L).title("Torsk").description("En god fisk").category("Fiskar").build();
    private static final ProductModel pingvin = new ProductBuilder().id(2L).title("Pingu").description("Svartvit fågel").category("Fåglar").build();

    @Test
    public void testAddProduct(){
        productController.createProduct(torsk);
        verify(productService).saveProduct(torsk);
    }
    @Test
    public void testDeleteProduct(){
        productController.deleteProduct(2L);
        verify(productService).deleteProduct(2L);
    }
    @Test
    public void testUpdateProduct(){
        productController.updateProduct(2L, pingvin);
        verify(productService).updateProduct(2L, pingvin);
    }
    @Test
    public void testGetAllProducts(){
        ArrayList<ProductModel> listan = new ArrayList<ProductModel>();
        listan.add(torsk);
        listan.add(pingvin);
        ResponseEntity respons = new ResponseEntity<ArrayList<ProductModel>>(listan, HttpStatus.OK);
        given(productService.getAllProducts()).willReturn(Arrays.asList(torsk, pingvin));
        assertThat(productController.getAllProducts()).isEqualTo(respons);
    }
    @Test
    public void testGetSelectedProduct(){
        given(productService.getSelectedProduct(1L)).willReturn(torsk);
        ResponseEntity respons= new ResponseEntity<ProductModel>(torsk, HttpStatus.OK);
        assertThat(productController.getSelectedProduct(1L)).isEqualTo(respons);
    }
    @Test
    public void testGetProductByCategory(){
        ArrayList<ProductModel> listan = new ArrayList<ProductModel>();
        listan.add(pingvin);
        ResponseEntity respons = new ResponseEntity<ArrayList<ProductModel>>(listan, HttpStatus.OK);
        given(productService.getAllProductsByCategory("Fåglar")).willReturn(Arrays.asList(pingvin));
        assertThat(productController.getProductsByCategory("Fåglar")).isEqualTo(respons);
    }

}
