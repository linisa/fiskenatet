package com.example.fiskenatet.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Erik on 2016-04-27.
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "users")
public class UserModel implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<ProductModel> listOfProducts;

    @OneToMany(mappedBy = "bidder", cascade = CascadeType.ALL)
    private List<BidModel> listOfBids;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String eMail;

    @Column(name = "mobile_number")
    private String mobileNumber;  //int eller String?

    @Column(name = "rating_as_seller")
    private int ratingAsSeller;

    @Column(name = "rating_as_buyer")
    private int ratingAsBuyer;


    public Long getId() {

        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String geteMail() {

        return eMail;
    }

    public void seteMail(String eMail) {

        this.eMail = eMail;
    }

    public String getMobileNumber() {

        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {

        this.mobileNumber = mobileNumber;
    }

    public int getRatingAsSeller() {
        return ratingAsSeller;
    }

    public void setRatingAsSeller(int ratingAsSeller) {
        this.ratingAsSeller = ratingAsSeller;
    }

    public int getRatingAsBuyer() {
        return ratingAsBuyer;
    }

    public void setRatingAsBuyer(int ratingAsBuyer) {
        this.ratingAsBuyer = ratingAsBuyer;
    }


    public List<ProductModel> getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(List<ProductModel> listOfProducts) {
        this.listOfProducts = listOfProducts;
    }


}
