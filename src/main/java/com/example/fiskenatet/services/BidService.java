package com.example.fiskenatet.services;

import com.example.fiskenatet.main.MailHandler;
import com.example.fiskenatet.models.BidModel;
import com.example.fiskenatet.models.ProductModel;
import com.example.fiskenatet.models.UserModel;
import com.example.fiskenatet.repositories.BidRepository;
import com.example.fiskenatet.repositories.ProductRepository;
import com.example.fiskenatet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by nordi_000 on 2016-04-27.
 */
@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    private UserModel formerLeadingBidder = new UserModel();
    private BidModel formerLeadingBid = new BidModel();
    private static final Logger LOGGER = Logger.getLogger(BidService.class.getName());

    public void saveBid(BidModel bidModel) {

        ProductModel currentProduct = productRepository.getOne(bidModel.getCurrentProduct());
        //ProductModel currentProduct = productRepository.getOne(1L);
        boolean formerBidderExist = getNextBiggestBid(currentProduct);
        if(formerBidderExist) {
            MailHandler mailHandler = new MailHandler();
            mailHandler.sendNewBidNotification(currentProduct, bidModel, formerLeadingBidder);
        }
        bidRepository.saveAndFlush(bidModel);
    }

    private boolean getNextBiggestBid (ProductModel currentProduct) {
        LOGGER.setLevel(Level.INFO);
        ConsoleHandler consoleHandler = new ConsoleHandler();
        LOGGER.addHandler(consoleHandler);
    try {
        List<BidModel> bidList = currentProduct.getListOfBids();
        int sizeOfList = bidList.size();
        if (sizeOfList > 0) {
            formerLeadingBid.setAmount(0);
            for (BidModel bidModel : bidList) {
                if (bidModel.getAmount() > formerLeadingBid.getAmount()) {
                    formerLeadingBid.setAmount(bidModel.getAmount());
                    formerLeadingBidder = userRepository.getOne(bidModel.getBidder());
                    formerLeadingBid.setBidder(formerLeadingBidder);
                }
            }
            return true;

        }


    }catch(ArrayIndexOutOfBoundsException ex){
            LOGGER.log(Level.SEVERE, "ERROR", ex);
        }
        return false;
    }


}
