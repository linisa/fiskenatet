package com.example.fiskenatet.controllers;

import com.example.fiskenatet.models.ProductModel;
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

    // lägg till ny user
    @CrossOrigin
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void createUser(@RequestBody UserModel userModel) {
        userService.saveUser(userModel);
    }

    // hämta specifik user med ID
    @CrossOrigin
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserModel> getUser(@PathVariable Long id) {
        return new ResponseEntity<UserModel>(userService.getUser(id), HttpStatus.OK);
    }

    // hämta specifik user med USERNAME
    @CrossOrigin
    @RequestMapping(value = "/username/{userName}", method = RequestMethod.GET)
    public ResponseEntity<UserModel>getUserByName(@PathVariable String userName) {
        return new ResponseEntity<UserModel>(userService.getUserByName(userName), HttpStatus.OK);
    }

    // hämta alla users
    @CrossOrigin
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return new ResponseEntity<List<UserModel>>(userService.getAllUsers(), HttpStatus.OK);
    }

    // delete specifik user
    @CrossOrigin
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    // uppdatera användare - EJ KLAR
    @CrossOrigin
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable Long id, @RequestBody UserModel userModel){
        userService.updateUser(id, userModel);
    }
}
