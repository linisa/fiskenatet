package com.example.fiskenatet.controllers;

import com.example.fiskenatet.models.UserModel;
import com.example.fiskenatet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void createProduct(@RequestBody UserModel userModel) {
        System.out.println("i controller!!!");
        userService.saveUser(userModel);
    }

}
