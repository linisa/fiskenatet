package com.example.fiskenatet.services;

import com.example.fiskenatet.models.BidModel;
import com.example.fiskenatet.models.ProductModel;
import com.example.fiskenatet.models.UserModel;
import com.example.fiskenatet.repositories.BidRepository;
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

    public void saveBid(BidModel bidModel) {
        bidRepository.saveAndFlush(bidModel);
    }


    // hämtar alla buden
    public ArrayList<BidModel> getAllBids() {
        return (ArrayList<BidModel>) bidRepository.findAll();
    }


}
