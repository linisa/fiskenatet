package com.fiskenatet.UnitTestingMockito;

import com.fiskenatet.controllers.ProductController;
import com.fiskenatet.models.ProductModel;
import com.fiskenatet.models.UserModel;
import com.fiskenatet.repositories.ProductRepository;
import com.fiskenatet.services.ProductService;
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
    private static final String IS_NOT_SOLD = "No";
    private static final String IS_SOLD = "Yes";
    private static final Long OWNER_ID_1 = 1L;
    private static final UserModel OWNER_1 = new UserBuilder().id(OWNER_ID_1).firstName("Pelle").build();
    private static final Long OWNER_ID_2 = 2L;
    private static final UserModel OWNER_2 = new UserBuilder().id(OWNER_ID_2).firstName("Kalle").build();

    private static final ProductModel fish1 = new ProductBuilder().id(ID_1).title(TITLE_1).category(CATEGORY_1).owner(OWNER_1).isSold(IS_SOLD).build();
    private static final ProductModel fish2 = new ProductBuilder().id(ID_2).title(TITLE_2).category(CATEGORY_2).owner(OWNER_2).isSold(IS_NOT_SOLD).build();

    @Test
    public void testCreateProduct(){
        String response = "OK";
        given(productService.validateProductInput(fish1)).willReturn(response);
        assertThat(productController.updateProduct(ID_1, fish1)).isEqualTo(response);
    }
    @Test
    public void testDeleteProduct(){
        productController.deleteProduct(ID_2);
        verify(productService).deleteProductInDatabase(ID_2);
    }
    @Test
    public void testUpdateProduct(){
        String response = "OK";
        given(productService.validateProductInput(fish2)).willReturn(response);
        assertThat(productController.updateProduct(ID_2, fish2)).isEqualTo(response);
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
    public void testGetProductByOwnerAndByCategory(){
        ArrayList<ProductModel>productList = new ArrayList<ProductModel>();
        productList.add(fish1);
        ResponseEntity responsMessage = new ResponseEntity<ArrayList<ProductModel>>(productList, HttpStatus.OK);
        given(productService.findProductByOwnerAndByCategory(CATEGORY_1, OWNER_ID_1)).willReturn(Arrays.asList(fish1));
        assertThat(productController.getProductByOwnerAndByCategory(CATEGORY_1, OWNER_ID_1)).isEqualTo(responsMessage);
    }

    @Test
    public void testUpdateProductWhenSold(){
        productController.updateProductWhenSold(ID_1);
        verify(productService).updateProductWhenSold(ID_1);
    }
    @Test
    public void testSearchProducts(){
        ArrayList<ProductModel> productList = new ArrayList<ProductModel>();
        productList.add(fish2);
        ResponseEntity responsMessage = new ResponseEntity<ArrayList<ProductModel>>(productList, HttpStatus.OK);
        given(productService.searchProducts(TITLE_2)).willReturn(Arrays.asList(fish2));
        assertThat(productController.searchProducts(TITLE_2)).isEqualTo(responsMessage);
    }
    @Test
    public void testGetNotSoldProductsByCategory(){
        ArrayList<ProductModel>productList = new ArrayList<ProductModel>();
        productList.add(fish2);
        ResponseEntity responsMessage = new ResponseEntity<ArrayList<ProductModel>>(productList, HttpStatus.OK);
        given(productService.findAllProductsByCategoryNotSold(CATEGORY_2)).willReturn(Arrays.asList(fish2));
        assertThat(productController.getNotSoldProductsByCategory(CATEGORY_2)).isEqualTo(responsMessage);
    }
    @Test
    public void testGetUnsoldProducts(){
        ArrayList<ProductModel>productList = new ArrayList<ProductModel>();
        productList.add(fish2);
        ResponseEntity responsMessage = new ResponseEntity<ArrayList<ProductModel>>(productList, HttpStatus.OK);
        given(productService.findProductsByIsSold(IS_NOT_SOLD)).willReturn(Arrays.asList(fish2));
        assertThat(productController.getUnsoldProducts(IS_NOT_SOLD)).isEqualTo(responsMessage);
    }
    @Test
    public void testAuctionDayEnd(){
        productController.auctionDayEnd();
        verify(productService).auctionDayEnd();
    }
    @Test
    public void testCreateHistory(){
        productController.createHistory(ID_1);
        verify(productService).moveConfirmedProductToHistory(ID_1);
    }

}
