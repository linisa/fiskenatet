package com.example.fiskenatet.controllers;

import com.example.fiskenatet.models.UserModel;
import com.example.fiskenatet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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

    @CrossOrigin
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<UserModel>> readAllUser() {
        return new ResponseEntity<ArrayList<UserModel>>(userService.getAllUsers(), HttpStatus.OK);
    }

}
