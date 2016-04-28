package com.example.fiskenatet.testBids;

import com.example.fiskenatet.testProducts.TestProductDAL;
import com.example.fiskenatet.testProducts.TestProductModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by nordi_000 on 2016-04-28.
 */
public class TestBidDAL {

    private static TestBidDAL testBidDAL = new TestBidDAL();

    public List<TestBidModel> getAllBids() {
        return Collections.emptyList();
    }

    public TestBidModel getBidModel(Long id) {
        return null;
    }

    public int addBidModel(TestBidModel testBidModel) {
        return testBidModel.getAmount();
    }



    public static TestBidDAL getInstance() {
        return testBidDAL;
    }



}
