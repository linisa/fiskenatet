package com.example.fiskenatet.services;

import java.util.ArrayList;
import java.util.List;

import com.example.fiskenatet.main.NotificationHandler;
import com.example.fiskenatet.models.UserModel;
import com.example.fiskenatet.repositories.UserRepository;
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
    @Autowired
    private UserRepository userRepository;

    // skapa produkt
    public void saveProduct(ProductModel productModel) {
        productRepository.saveAndFlush(productModel); // saveandflush betyder sparar och skickar upp till databasen(?) direkt
    }

    // hämta alla produkter
    public List<ProductModel> findAllProducts() {
        return (ArrayList<ProductModel>)productRepository.findAll();
    }


    // hämta alla produkter från kategori - EJ KLAR
    public List<ProductModel> findAllProductsByCategory(String category) {
        return (List<ProductModel>) productRepository.findProductsByCategory(category);
    }

    // hämta en specifik produkt
    public ProductModel findSelectedProduct(Long id){
        return productRepository.getOne(id);
    }

    // delete en produkt
    public void deleteProductInDatabase(Long id){
        productRepository.delete(id);
    }

    // uppdatera en produkt
    public void updateProductInDatabase(Long id, ProductModel productModel) {
        ProductModel productToUpdate = productRepository.getOne(id);
        productToUpdate.setTitle(productModel.getTitle());
        productToUpdate.setDescription(productModel.getDescription());
        productToUpdate.setBuyNowPrice(productModel.getBuyNowPrice());
        productToUpdate.setCategory(productModel.getCategory());
        productToUpdate.setImage(productModel.getImage());
        productToUpdate.setEndDate(productModel.getStartDate());
        productToUpdate.setStartPrice(productModel.getStartPrice());
        productRepository.saveAndFlush(productToUpdate);
    }
    public void updateProductWhenSold(Long id){
        ProductModel soldProduct = productRepository.getOne(id);
        soldProduct.setIsSold("yes");
        NotificationHandler notificationHandler = new NotificationHandler();
        UserModel userModel = userRepository.getOne(soldProduct.getOwner());
        notificationHandler.notifySeller(soldProduct, userModel);
        productRepository.saveAndFlush(soldProduct);
    }

    public void sendNotis() {

    }


}

