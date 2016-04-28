package com.example.fiskenatet;

/**
 * Created by nordi_000 on 2016-04-26.
 */
public class TestProductModel {

    private long id;
    private String title;
    private int startPrice;
    private int endPrice;

    public TestProductModel(long id, String title, int startPrice, int endPrice) {
        this.id = id;
        this.title = title;
        this.startPrice = startPrice;
        this.endPrice = endPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(int startPrice) {
        this.startPrice = startPrice;
    }

    public int getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(int endPrice) {
        this.endPrice = endPrice;
    }
}
