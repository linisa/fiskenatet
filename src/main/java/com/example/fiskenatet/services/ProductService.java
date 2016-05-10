package com.example.fiskenatet.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public List<ProductModel> findProductsByIsSold(String isSold){
        return (List<ProductModel>) productRepository.findProductsByIsSold(isSold);
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


    public void updateProductWhenSold(Long id) {
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

            mailHandler.sendLoserNotification(soldProduct, loser, owner, highestBid);
        }
        productRepository.saveAndFlush(soldProduct);
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

