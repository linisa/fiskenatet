package com.example.fiskenatet.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fiskenatet.models.ProductModel;
import com.example.fiskenatet.repositories.ProductRepository;

/**
 * Created by nordi_000 on 2016-04-20.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // skapa
    public void saveProduct(ProductModel productModel) {
        productRepository.saveAndFlush(productModel); // saveandflush betyder sparar och skickar upp till databasen(?) direkt
    }

    // hämta alla produkter
    public ArrayList<ProductModel> getAllProducts() {
        return (ArrayList<ProductModel>)productRepository.findAll();
    }


    // hämta en specifik produkt
    public ProductModel getSelectedProduct(Long id){
        return productRepository.getOne(id);
    }

    // delete en produkt

    public void deleteProduct(Long id){
        productRepository.delete(id);
    }

    public void updateProduct(Long id, ProductModel productModel) {
        ProductModel productToUpdate = productRepository.getOne(id);
        productToUpdate.setTitle(productModel.getTitle());
        productToUpdate.setDescription(productModel.getDescription());
        productToUpdate.setBuyNowPrice(productModel.getBuyNowPrice());
        productToUpdate.setCategory(productModel.getCategory());
        productToUpdate.setImage(productModel.getImage());
        productToUpdate.setStartDate(productModel.getStartDate());
        productToUpdate.setEndDate(productModel.getStartDate());
        productToUpdate.setStartPrice(productModel.getStartPrice());
        productToUpdate.setHighestBid(productModel.getHighestBid());
        productRepository.saveAndFlush(productToUpdate);
    }
}

