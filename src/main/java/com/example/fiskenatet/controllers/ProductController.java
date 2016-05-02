package com.example.fiskenatet.controllers;


import java.util.ArrayList;
import java.util.List;

import com.example.fiskenatet.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.fiskenatet.models.ProductModel;
import com.example.fiskenatet.services.ProductService;

@RestController
public class ProductController {

    @Autowired //inkluderar alla dependency raderna ish.
    private ProductService productService;

    // skapa en produkt
    @CrossOrigin
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public void createProduct(@RequestBody ProductModel productModel) {
        productService.saveProduct(productModel);
    }

    // hämta alla produkter
    @CrossOrigin
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return new ResponseEntity<List<ProductModel>>(productService.getAllProducts(), HttpStatus.OK);
    }

    // delete en produkt
    @CrossOrigin
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }


    // Uppdatera en produkt
    @CrossOrigin
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public void updateProduct(@PathVariable Long id, @RequestBody ProductModel productModel){
        productService.updateProduct(id, productModel);
    }

    // hämtar en specifik produkt
    @CrossOrigin
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ResponseEntity <ProductModel> getSelectedProduct(@PathVariable Long id){
        return new ResponseEntity<ProductModel>(productService.getSelectedProduct(id), HttpStatus.OK);
    }

    // hämtar alla produkter från en vald kategori
    @CrossOrigin
    @RequestMapping(value = "/products/category/{category}", method = RequestMethod.GET)
    public ResponseEntity<List<ProductModel>>getProductsByCategory(@PathVariable String category) {
        return new ResponseEntity<List<ProductModel>>(productService.getAllProductsByCategory(category), HttpStatus.OK);
    }

}

