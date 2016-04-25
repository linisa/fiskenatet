package com.example.fiskenatet.controllers;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.fiskenatet.models.ProductModel;
import com.example.fiskenatet.services.ProductService;

@RestController
public class ProductController {

    @Autowired //inkluderar alla dependency raderna ish.
    private ProductService productService;

    @CrossOrigin
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public void createProduct(@RequestBody ProductModel productModel) {
        System.out.println("i controller!!!");
        productService.saveProduct(productModel);

    }

    @CrossOrigin
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<ProductModel>> readAll() {
        return new ResponseEntity<ArrayList<ProductModel>>(productService.getAllProducts(), HttpStatus.OK);
    }

}
