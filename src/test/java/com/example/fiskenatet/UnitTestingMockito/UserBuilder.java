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

    public UserModel build(){
        return userModel;
    }
}
