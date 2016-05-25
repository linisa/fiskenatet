package com.example.fiskenatet.UnitTestingMockito;

import com.example.fiskenatet.models.UserModel;

/**
 * Created by nordi_000 on 2016-04-29.
 */
public class UserBuilder {
    private UserModel userModel = new UserModel();

    public UserBuilder id (Long id) {
        userModel.setId(id);
        return this;
    }

    public UserBuilder userName (String userName){
        userModel.setUserName(userName);
        return this;
    }
    public UserBuilder firstName(String firstName){
        userModel.setFirstName(firstName);
        return this;
    }
    public UserBuilder lastName (String lastName){
        userModel.setLastName(lastName);
        return this;
    }
    public UserBuilder email (String email){
        userModel.setEmail(email);
        return this;
    }
    public UserBuilder mobileNumber (String mobileNumber){
        userModel.setMobileNumber(mobileNumber);
        return this;
    }
    public UserBuilder sellerRating (String sellerRating){
        userModel.setRatingAsSeller(sellerRating);
        return this;
    }
    public UserBuilder buyerRating(String buyerRating){
        userModel.setRatingAsBuyer(buyerRating);
        return this;
    }

    public UserModel build(){
        return userModel;
    }
}
