package com.example.fiskenatet.testValidation;

import com.example.fiskenatet.main.Validation;
import com.example.fiskenatet.models.HistoryModel;
import com.example.fiskenatet.models.ProductModel;
import com.example.fiskenatet.models.UserModel;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Linus on 2016-05-17.
 */
public class TestValidation extends TestCase{

    Validation validation;
    ProductModel productModel;
    UserModel userModel, userModel2, userModel3;
    HistoryModel historyModel;
    List<UserModel> userList;
    List<HistoryModel> historyList;

    String checkUser = "OK";

    public void setUp() throws Exception{
        super.setUp();
        validation = new Validation();
        productModel = new ProductModel();
        userList = new ArrayList<UserModel>();
        historyList = new ArrayList<HistoryModel>();
        productModel.setTitle("Torsk");
        productModel.setDescription("Jete godd");
        productModel.setCategory("Lax");
        productModel.setImage("http://www.gabrielalares.com/wp-content/uploads/2013/12/torsk500.jpg");
        productModel.setStartPrice(1);
        productModel.setBuyNowPrice(2);

        userModel = new UserModel();
        userModel.setFirstName("Kalle");
        userModel.setLastName("Anka");
        userModel.setUserName("kallis");
        userModel.setEmail("kalle@anka.ank");
        userModel.setMobileNumber("123456");
        userModel2 = new UserModel();
        userModel2.setFirstName("Musse");
        userModel2.setLastName("Pigg");
        userModel2.setUserName("muppig");
        userModel2.setEmail("musse@pigg.ank");
        userModel2.setMobileNumber("654321");
        userModel3 = new UserModel();
        userModel3.setFirstName("Janne");
        userModel3.setLastName("Långben");
        userModel3.setUserName("janne");
        userModel3.setEmail("janne@lång.ben");
        userModel3.setMobileNumber("100000");
        userList.add(userModel);
        userList.add(userModel2);

        historyModel = new HistoryModel();
        historyModel.setBuyerUsername("bubba");
        historyModel.setOwner(userModel);
        historyList.add(historyModel);
    }
    public void testValidateProductInput(){
        assertEquals("OK", validation.validateProductInput(productModel));
    }
    public void testControlUserInput(){
        assertEquals("OK", validation.controlUserInput(userModel, checkUser));
    }
    public void testValidateUserMailAndEmail(){
        assertEquals("OK", validation.validateUserNameAndEmail(userList, historyList, userModel3));
    }

}
