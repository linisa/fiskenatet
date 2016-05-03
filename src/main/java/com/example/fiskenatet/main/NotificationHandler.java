package com.example.fiskenatet.main;

import com.example.fiskenatet.models.ProductModel;
import com.example.fiskenatet.models.UserModel;

/**
 * Created by nordi_000 on 2016-05-03.
 */
public class NotificationHandler {

    public void notifySeller(ProductModel productModel, UserModel userModel){
        sendEmail(userModel.getEmail(), productModel);

    }
    public void notifyLosers(){

    }
    public void notifyWinner(){

    }
    public void sendEmail(String email, ProductModel productModel){

    }
}
