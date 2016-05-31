package com.fiskenatet.testBids;

import com.fiskenatet.testProducts.TestProductModel;

/**
 * Created by nordi_000 on 2016-04-28.
 */
public class TestBidModel {

    private long id;
    private int amount;
    private long bidder_id;
    private TestProductModel testProductModel;
    private long product_id;

    public TestBidModel(long id, int amount, long bidder_id, TestProductModel testProductModel, long product_id) {
        this.id = id;
        this.amount = amount;
        this.bidder_id = bidder_id;
        this.testProductModel = testProductModel;
        this.product_id = product_id;
    }

    public TestBidModel() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getBidder_id() {
        return bidder_id;
    }

    public void setBidder_id(long bidder_id) {
        this.bidder_id = bidder_id;
    }

    public TestProductModel getTestProductModel() {
        return testProductModel;
    }

    public void setTestProductModel(TestProductModel testProductModel) {
        this.testProductModel = testProductModel;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }
}
