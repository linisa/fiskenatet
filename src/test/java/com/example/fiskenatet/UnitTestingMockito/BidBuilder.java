package com.example.fiskenatet.UnitTestingMockito;

import com.example.fiskenatet.models.BidModel;
import com.example.fiskenatet.models.ProductModel;
import com.example.fiskenatet.models.UserModel;

import java.util.Date;

/**
 * Created by nordi_000 on 2016-05-02.
 */
public class BidBuilder {

    private BidModel bidModel = new BidModel();

    public BidBuilder id (Long id){
        bidModel.setId(id);
        return this;
    }

    public BidBuilder amount (int amount){
        bidModel.setAmount(amount);
        return this;
    }

    public BidBuilder bidder (UserModel bidder){
        bidModel.setBidder(bidder);
        return this;
    }
    public BidBuilder date (Date date){
        bidModel.setBidDate(date);
        return this;
    }
    public BidBuilder currentProduct (ProductModel productModel){
        bidModel.setCurrentProduct(productModel);
        return this;
    }
    public BidModel build(){
        return bidModel;
    }
}
