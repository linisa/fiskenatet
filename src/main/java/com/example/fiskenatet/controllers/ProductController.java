package com.example.fiskenatet.controllers;


import java.util.ArrayList;

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

    @CrossOrigin
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public void createProduct(@RequestBody ProductModel productModel) {
        productService.saveProduct(productModel);
    }

    @CrossOrigin
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<ProductModel>> readAll() {
        return new ResponseEntity<ArrayList<ProductModel>>(productService.getAllProducts(), HttpStatus.OK);
    }
<<<<<<< HEAD


=======
>>>>>>> 2048a11cfb1474211036fb7c38338889d5b7fd82

    @CrossOrigin
    @RequestMapping(value = "/products", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
<<<<<<< HEAD
=======

>>>>>>> 2048a11cfb1474211036fb7c38338889d5b7fd82
}

