package com.example.fiskenatet.controllers;


import java.util.ArrayList;
import java.util.List;

import com.example.fiskenatet.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.fiskenatet.models.ProductModel;
import com.example.fiskenatet.services.ProductService;

import javax.validation.Valid;

@RestController
public class ProductController {

    @Autowired //inkluderar alla dependency raderna ish.
    private ProductService productService;

    //kollar om alla produktinputs är korrekt
    // om allt är ok, skapas en ny produkt till databasen
    @CrossOrigin
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String createProduct(@RequestBody ProductModel productModel) {
        String validProduct = productService.validateProductInput(productModel);
        if(validProduct.equals("OK")) {
            productService.saveProduct(productModel);
        }
        return validProduct;
    }

    // hämta alla produkter
    @CrossOrigin
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return new ResponseEntity<List<ProductModel>>(productService.findAllProducts(), HttpStatus.OK);
    }

    // delete en produkt
    @CrossOrigin
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProductInDatabase(id);
    }


    // Uppdatera en produkt
    @CrossOrigin
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public String updateProduct(@PathVariable Long id, @RequestBody ProductModel productModel){
        String validProduct = productService.validateProductInput(productModel);
        if(validProduct.equals("OK")) {
            productService.updateProductInDatabase(id, productModel);
        }
        return validProduct;
    }

    // Sätt produkt till såld
    @CrossOrigin
    @RequestMapping(value = "/products/issold/{id}", method = RequestMethod.PUT)
    public void updateProductWhenSold(@PathVariable Long id){
        productService.updateProductWhenSold(id);
    }

    // hämtar en specifik produkt
    @CrossOrigin
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ResponseEntity <ProductModel> getSelectedProduct(@PathVariable Long id){
        return new ResponseEntity<ProductModel>(productService.findSelectedProduct(id), HttpStatus.OK);
    }

    // hämtar alla produkter från en vald kategori
    @CrossOrigin
    @RequestMapping(value = "/products/category/{category}", method = RequestMethod.GET)
    public ResponseEntity<List<ProductModel>>getProductsByCategory(@PathVariable String category) {
        return new ResponseEntity<List<ProductModel>>(productService.findAllProductsByCategory(category), HttpStatus.OK);
    }

    //hämtar produkter från en vald kategori för en viss användare
    @CrossOrigin
    @RequestMapping(value = "/products/byownerandcategory/{category}/{ownerId}", method = RequestMethod.GET)
    public ResponseEntity<List<ProductModel>>getProductByOwnerAndByCategory(@PathVariable String category,@PathVariable Long ownerId) {
        return new ResponseEntity<List<ProductModel>>(productService.getProductByOwnerAndByCategory(category, ownerId), HttpStatus.OK);
    }

    //sätter en produkt till såld
    @CrossOrigin
    @RequestMapping(value = "/products/productissold/{isSold}", method = RequestMethod.GET)
    public ResponseEntity<List<ProductModel>>getUnsoldProducts(@PathVariable String isSold) {
        return new ResponseEntity<List<ProductModel>>(productService.findProductsByIsSold(isSold), HttpStatus.OK);
    }

    // sök produkt
    @CrossOrigin
    @RequestMapping(value = "/products/search/{value}", method = RequestMethod.GET)
    public ResponseEntity<List<ProductModel>>searchProducts(@PathVariable String value) {
        return new ResponseEntity<List<ProductModel>>(productService.searchProducts(value), HttpStatus.OK);
    }

}

