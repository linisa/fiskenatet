package com.example.fiskenatet.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import com.example.fiskenatet.logging.Logging;
import com.example.fiskenatet.main.MailHandler;
import com.example.fiskenatet.models.BidModel;
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

    Logging logging = new Logging();
    Logger log = logging.createLog();

    // skapa produkt
    public void saveProduct(ProductModel productModel) {
        productRepository.saveAndFlush(productModel);
        log.info("New product created with ID: " +productModel.getId());
    }

    // hämta alla produkter
    public List<ProductModel> findAllProducts() {
        return (ArrayList<ProductModel>)productRepository.findAll();
    }


    // hämta alla produkter från kategori
    public List<ProductModel> findAllProductsByCategory(String category) {
        return (List<ProductModel>) productRepository.findProductsByCategory(category);
    }

    public List<ProductModel> findProductsByIsSold(String isSold){
        return (List<ProductModel>) productRepository.findProductsByIsSold(isSold);
    }

    // hämta en produkt från en vald kategori och användare - EJ KLAR
    public List<ProductModel> getProductByOwnerAndByCategory(String category, Long ownerId) {
        List<ProductModel> productList = productRepository.findProductsByCategoryAndOwnerId(category, ownerId);
        log.info("Called method 'findProductsByCategoryAndOwnerId' that returned a list of " +productList.size()+
                " products from owner with ID " +ownerId+ " and category '" +category+ "'");
        return productList;
    }

    // hämta en specifik produkt
    public ProductModel findSelectedProduct(Long id){
        ProductModel product = productRepository.getOne(id);
        log.info("Called method 'findSelectedProduct' and returned product with ID = " +product.getId());
        return product;

    }

    // delete en produkt
    public void deleteProductInDatabase(Long id){
        productRepository.delete(id);
        log.info("Product deleted with ID = " +id);
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


    public void updateProductWhenSold(Long id) {
        System.out.println("i prodService set sold");
        ProductModel soldProduct = productRepository.getOne(id);

        soldProduct.setIsSold("yes");
        MailHandler mailHandler = new MailHandler();
        UserModel owner = userRepository.getOne(soldProduct.getOwner());
        List<BidModel> bidList = soldProduct.getListOfBids();
        int size = bidList.size();

        BidModel highestBid = bidList.get(size - 1);
        UserModel winner = userRepository.getOne(highestBid.getBidder());
        mailHandler.sendWinnerNotification(owner, winner, soldProduct);
        mailHandler.sendSellerNotification(owner, winner, soldProduct);
        ArrayList<UserModel> loserList = (ArrayList)getAllLosers(winner, bidList);
        for(UserModel loser : loserList){

        //UserModel userModel = userRepository.getOne(soldProduct.getOwner());
            mailHandler.sendLoserNotification(soldProduct, loser, owner, highestBid);
        }
        productRepository.saveAndFlush(soldProduct);
        log.info("Product with ID = " +soldProduct.getId()+ " has been set to sold");
    }

    private List<UserModel> getAllLosers(UserModel winner, List<BidModel> bidList) {
        List<UserModel> loserList = new ArrayList<UserModel>();
        Set<UserModel> userHashSet = new HashSet<UserModel>();
        for (BidModel bid : bidList) {
            if (bid.getBidder() != winner.getId()) {
                loserList.add(userRepository.getOne(bid.getBidder()));
            }
        }
        userHashSet.addAll(loserList);
        loserList.clear();
        loserList.addAll(userHashSet);
        return loserList;
    }

}

