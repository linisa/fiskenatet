package com.fiskenatet.controllers;

import com.fiskenatet.models.BidModel;
import com.fiskenatet.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BidController {

    @Autowired
    private BidService bidService;

    // skapa bud
    @CrossOrigin
    @RequestMapping(value = "/bids", method = RequestMethod.POST)
    public void createBid(@RequestBody BidModel bidModel) {
        System.out.println("budgivarens id: " + bidModel.getBidder());
        bidService.saveBid(bidModel);
    }

}
