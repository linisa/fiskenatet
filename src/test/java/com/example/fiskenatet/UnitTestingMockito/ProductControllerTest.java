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

    private static final Long ID_1 = 1L;
    private static final Long ID_2 = 2L;
    private static final String TITLE_1 = "Torsk";
    private static final String TITLE_2 = "Blåval";
    private static final String CATEGORY_1 = "Fiskar";
    private static final String CATEGORY_2 = "Valar";

    private static final ProductModel fish1 = new ProductBuilder().id(ID_1).title(TITLE_1).category(CATEGORY_1).build();
    private static final ProductModel fish2 = new ProductBuilder().id(ID_2).title(TITLE_2).category(CATEGORY_2).build();

    @Test
    public void testAddProduct(){
        productController.createProduct(fish1);
        verify(productService).saveProduct(fish1);
    }
    @Test
    public void testDeleteProduct(){
        productController.deleteProduct(ID_2);
        verify(productService).deleteProductInDatabase(ID_2);
    }
    @Test
    public void testUpdateProduct(){
        productController.updateProduct(ID_2, fish2);
        verify(productService).updateProductInDatabase(ID_2, fish2);
    }
    @Test
    public void testGetAllProducts(){
        ArrayList<ProductModel> productList = new ArrayList<ProductModel>();
        productList.add(fish1);
        productList.add(fish2);
        ResponseEntity respons = new ResponseEntity<ArrayList<ProductModel>>(productList, HttpStatus.OK);
        given(productService.findAllProducts()).willReturn(Arrays.asList(fish1, fish2));
        assertThat(productController.getAllProducts()).isEqualTo(respons);
    }
    @Test
    public void testGetSelectedProduct(){
        given(productService.findSelectedProduct(ID_1)).willReturn(fish1);
        ResponseEntity respons= new ResponseEntity<ProductModel>(fish1, HttpStatus.OK);
        assertThat(productController.getSelectedProduct(ID_1)).isEqualTo(respons);
    }
    @Test
    public void testGetProductByCategory(){
        ArrayList<ProductModel> productList = new ArrayList<ProductModel>();
        productList.add(fish2);
        ResponseEntity responsMessage = new ResponseEntity<ArrayList<ProductModel>>(productList, HttpStatus.OK);
        given(productService.findAllProductsByCategory(CATEGORY_2)).willReturn(Arrays.asList(fish2));
        assertThat(productController.getProductsByCategory(CATEGORY_2)).isEqualTo(responsMessage);
    }

    @Test
    public void testUpdateProductWhenSold(){
        productController.updateProductWhenSold(ID_1);
        verify(productService).updateProductWhenSold(ID_1);
    }

}
