package com.example.fiskenatet.UnitTestingMockito;

import com.example.fiskenatet.models.BidModel;

/**
 * Created by nordi_000 on 2016-05-02.
 */
public class BidBuilder {

    private BidModel bidModel = new BidModel();

    public BidModel build(){
        return bidModel;
    }
}
