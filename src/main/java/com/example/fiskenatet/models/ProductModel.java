package com.example.fiskenatet.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by nordi_000 on 2016-04-20.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "products")
public class ProductModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private long id;
    //private CustomerModel ownerID;

    @Column(name = "buy_now_price")
    private int buyNowPrice;

    @Column(name = "start_price")
    private int startPrice;

    @Column(name = "long_description")
    private String longDescription;

    @Column(name = "short_description")
    private String shortDescription;

    
    private String title;

    @Column(name = "start_date")
    private Date startDate; //datum + tid?

    @Column(name = "end_date")
    private Date endDate; //datum + tid?

    //private ArrayList<BidModel> bidList;

    @Column(name = "highest_bid")
    private int highestBid;
    
    private String image;

    private String category;

    public ProductModel() {}

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(int highestBid) {
        this.highestBid = highestBid;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public int getBuyNowPrice() {
        return buyNowPrice;
    }

    public void setBuyNowPrice(int buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
    }

    public int getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(int startPrice) {
        this.startPrice = startPrice;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}

