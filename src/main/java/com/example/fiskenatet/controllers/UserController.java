package com.example.fiskenatet.controllers;

import com.example.fiskenatet.models.UserModel;
import com.example.fiskenatet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void createUser(@RequestBody UserModel userModel) {
        userService.saveUser(userModel);
    }

    @CrossOrigin
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserModel> getUser(@PathVariable Long id) {
        return new ResponseEntity<UserModel>(userService.getUser(id), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/username/{userName}", method = RequestMethod.GET)
    public ResponseEntity<UserModel>getUserByName(@PathVariable String userName) {
        return new ResponseEntity<UserModel>(userService.getUserByName(userName), HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/users/", method = RequestMethod.GET)
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return new ResponseEntity<List<UserModel>>(userService.getAllUsers(), HttpStatus.OK);
    }


}
