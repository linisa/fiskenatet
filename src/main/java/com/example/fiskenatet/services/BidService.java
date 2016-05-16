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

    public void saveBid(BidModel bidModel) {

        ProductModel currentProduct = productRepository.getOne(bidModel.getCurrentProduct());
        boolean formerBidderExist = getNextBiggestBid(currentProduct);
        if(formerBidderExist) {
            MailHandler mailHandler = new MailHandler();
            mailHandler.sendNewBidNotification(currentProduct, bidModel, formerLeadingBidder);
        }
        bidRepository.saveAndFlush(bidModel);
    }

    private boolean getNextBiggestBid (ProductModel currentProduct) {
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

        return false;
    }

}
