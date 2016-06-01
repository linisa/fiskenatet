package com.fiskenatet.services;

import java.util.*;
import java.util.logging.Logger;

import Application;
import com.fiskenatet.stuff.MailHandler;
import com.fiskenatet.stuff.Validation;
import com.fiskenatet.models.BidModel;
import com.fiskenatet.models.HistoryModel;
import com.fiskenatet.models.UserModel;
import com.fiskenatet.repositories.BidRepository;
import com.fiskenatet.repositories.HistoryRepository;
import com.fiskenatet.repositories.UserRepository;
import com.fiskenatet.models.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiskenatet.repositories.ProductRepository;


/**
 * Created by nordi_000 on 2016-04-20.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private BidRepository bidRepository;

    private Validation validation = new Validation();
    Logger log = Logger.getLogger(Application.class.getName());

    // skapa produkt
    public void saveProduct(ProductModel productModel) {
        productRepository.saveAndFlush(productModel);
        log.info("New product created with ID: " +productModel.getId());
    }

    // hämta alla produkter
    public List<ProductModel> findAllProducts() {
        List<ProductModel> allProducts = productRepository.findAll();
        log.info("Called method 'findAllProducts' that returned a list of " + allProducts.size() + " products");
        return allProducts;
    }


    // hämta alla produkter från kategori
    public List<ProductModel> findAllProductsByCategory(String category) {
        List<ProductModel> productList = productRepository.findProductsByCategory(category);
        log.info("Called method 'findAllProductsByCategory' with category '" +category+ "' that returned a list of " +productList.size()+ " products");
        return productList;
    }

    // hämta alla produkter från kategori som inte är sålda
    public List<ProductModel> findAllProductsByCategoryNotSold(String category) {
        List<ProductModel> onlyNotSoldProducts = new ArrayList<ProductModel>();
        List<ProductModel> allProducts = productRepository.findProductsByCategory(category);
        for(ProductModel product : allProducts) {
            if(product.getIsSold().equals("no")) {
                onlyNotSoldProducts.add(product);
            }
        }
        log.info("Called method 'findAllProductsByCategoryNotSold' with category '" + category + "' that returned a list of " + onlyNotSoldProducts.size() + " products");
        return onlyNotSoldProducts;
    }

    public List<ProductModel> findProductsByIsSold(String isSold){
        List<ProductModel> productList = productRepository.findProductsByIsSold(isSold);
        log.info("Called method 'findProductsByIsSold' that returned a list of " +productList.size()+ " sold products");
        return productList;
    }

    // hämta en produkt från en vald kategori och användare - EJ KLAR
    public List<ProductModel> findProductByOwnerAndByCategory(String category, Long ownerId) {
        List<ProductModel> productList = productRepository.findProductsByCategoryAndOwnerId(category, ownerId);
        log.info("Called method 'getProductByOwnerAndByCategory' that returned a list of " +productList.size()+
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
        productToUpdate.setStartPrice(productModel.getStartPrice());
        productRepository.saveAndFlush(productToUpdate);
        log.info("Product " +id+ " has been updated");
    }

    // Sätter produkten till såld och skickar ut mail till winnaren/förlorarna
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

        //UserModel userModel = userRepository.getOne(soldProduct.getOwner());
            mailHandler.sendLoserNotification(soldProduct, loser, owner, highestBid);
        }
        productRepository.saveAndFlush(soldProduct);
        log.info("Product with ID = " +soldProduct.getId()+ " has been set to sold");
    }

    private void updateProductWhenNotSold(Long id) {
        ProductModel product = productRepository.getOne(id);
        MailHandler mailHandler = new MailHandler();
        UserModel owner = userRepository.getOne(product.getOwner());
        mailHandler.sendSellerNotificationProductNotSold(owner, product);
        //log.info("Product with ID = " +soldProduct.getId()+ " has been set to sold");
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
        log.info("Called method 'getAllLosers' that returned a list of " +loserList.size()+ " users");
        return loserList;
    }
    public List<ProductModel> searchProducts(String value) {
        List<ProductModel> searchResultList = new ArrayList<ProductModel>();
        Set<ProductModel> productHashSet = new HashSet<ProductModel>();
        List<ProductModel> titleList = productRepository.findProductsByTitleContaining(value);
        List<ProductModel> descriptionList = productRepository.findProductsByDescriptionContaining(value);

        for (ProductModel product : titleList) {
            searchResultList.add(product);
        }
        for (ProductModel product : descriptionList) {
            searchResultList.add(product);
        }
        productHashSet.addAll(searchResultList);
        searchResultList.clear();
        searchResultList.addAll(productHashSet);
        log.info("Search method 'searchProducts' ran with value: " +value+ " and found " +searchResultList.size()+ " product(s)");
        return searchResultList;
    }

    // Flytta produkter från schemat products till history om produkten skapades innan kl15:00 samma dag
    // Denna funktion kommer att köras strax efter kl 16:00 varje dag

    // 3: Kopiera alla produkter till history
    // 4: Radera från products
    //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");
    //sdf.format(date);
    public void auctionDayEnd() {
        boolean productIsSold;
        Date date = new Date();
        date.setHours(16);
        date.setMinutes(0);
        date.setSeconds(1);

        List<ProductModel> outgoingProducts = productRepository.findProductsByEndDateBefore(date);
        for(ProductModel product : outgoingProducts) {
            if(product.getListOfBids().isEmpty()) {
                // produkt utan bud --> Hantera
                updateProductWhenNotSold(product.getId());

                UserModel user = new UserModel();

                addProductToHistoryDatabase(product, false);
            } else {
                // produkt med bud --> Hantera
                updateProductWhenSold(product.getId());  // Sätter produkten till såld och skickar ut mail till winnaren/förlorarna
                //moveSoldProductToHistory(product, productIsSold);


            }
        }
    }

    // utan bud klar, funkar
    // med bud klart, funkar?
    // köp nu ej klart

    private void addProductToHistoryDatabase(ProductModel productModel, boolean productIsSold) {
        System.out.println("inne i funktionen i history service");
        HistoryModel historyModel = new HistoryModel();
        historyModel.setProdutID(productModel.getId());
        historyModel.setCategory(productModel.getCategory());
        historyModel.setDescription(productModel.getDescription());
        historyModel.setEndDate(productModel.getEndDate());
        historyModel.setImage(productModel.getImage());
        historyModel.setStartDate(productModel.getStartDate());
        historyModel.setTitle(productModel.getTitle());
        historyModel.setOwner(userRepository.getOne(productModel.getOwner()));
        if(productIsSold) {
            List<BidModel> bids = productModel.getListOfBids();
            int count = 0;
            for(BidModel bidLoop : bids) {
                count++;
            }
            count--;
            int soldFor = bids.get(count).getAmount();
            historyModel.setSoldFor(soldFor);
            UserModel bidder = userRepository.getOne(productModel.getListOfBids().get(productModel.getListOfBids().size()-1).getBidder());
            historyModel.setBuyerUsername(bidder.getUserName());
            historyRepository.saveAndFlush(historyModel);
        } else {
            // buyerUsername default "no buyer";
            // soldFor är by default 0
            historyRepository.saveAndFlush(historyModel);
            productRepository.delete(productModel);
        }
    }


    public void moveConfirmedProductToHistory(Long id) {
        ProductModel productModel = productRepository.getOne(id);
        addProductToHistoryDatabase(productModel, true);
        removeProductFromProductDatabase(productModel);
    }

    private void removeProductFromProductDatabase(ProductModel productModel) {
        List<BidModel> bidsOnProduct = bidRepository.findBidsByCurrentProduct(productModel);
        for(BidModel bid : bidsOnProduct) {
            bidRepository.delete(bid);
        }
        productRepository.delete(productModel);
    }

    public String validateProductInput(ProductModel productModel){
        String checkProduct = validation.validateProductInput(productModel);
        return checkProduct;
    }

}

