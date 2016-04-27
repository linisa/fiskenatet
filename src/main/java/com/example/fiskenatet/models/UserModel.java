package com.example.fiskenatet.models;

import javax.persistence.*;
import java.io.Serializable;

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
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;  //int eller String?

    @Column(name = "rating_as_seller")
    private int ratingAsSeller;

    @Column(name = "rating_as_buyer")
    private int ratingAsBuyer;




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

    public long getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
