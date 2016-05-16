package com.example.fiskenatet.controllers;

import com.example.fiskenatet.main.UserRating;
import com.example.fiskenatet.models.ProductModel;
import com.example.fiskenatet.models.UserModel;
import com.example.fiskenatet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //kolla databasen efter användarDubblett
    @CrossOrigin
    @RequestMapping(value = "/verifyuser", method = RequestMethod.POST)
    public String verifyUser(@RequestBody UserModel userModel) {
        return userService.checkIfUserExistsInDatabase(userModel);
    }
    //kollar så inga fält är tomma
    @CrossOrigin
    @RequestMapping(value = "/controluserinput", method = RequestMethod.POST)
    public String controlUserInput(@RequestBody UserModel userModel) {
        return userService.controlUserInput(userModel);
    }

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
        return new ResponseEntity<UserModel>(userService.findUser(id), HttpStatus.OK);
    }

    // hämta specifik user med USERNAME
    @CrossOrigin
    @RequestMapping(value = "/username/{userName}", method = RequestMethod.GET)
    public ResponseEntity<UserModel>getUserByUserName(@PathVariable String userName) {
        return new ResponseEntity<UserModel>(userService.findUserByUserName(userName), HttpStatus.OK);
    }


    // hämta alla users
    @CrossOrigin
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<UserModel>> getAllUsers() {
        return new ResponseEntity<List<UserModel>>(userService.findAllUsers(), HttpStatus.OK);
    }

    // delete specifik user
    @CrossOrigin
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserInDatabase(id);
    }

    // uppdatera användare - EJ KLAR
    @CrossOrigin
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable Long id, @RequestBody UserModel userModel){
        userService.updateUserInDatabase(id, userModel);
    }

    @CrossOrigin
    @RequestMapping(value = "/users/setbuyerrating/{id}", method = RequestMethod.PUT)
    public void rateABuyer(@PathVariable Long id, @RequestBody String addRating){
        userService.saveBuyerRating(id, addRating);
    }

    @CrossOrigin
    @RequestMapping(value = "/users/setsellerrating/{id}", method = RequestMethod.PUT)
    public void rateASeller(@PathVariable Long id, @RequestBody String addRating){
        userService.saveSellerRating(id, addRating);
    }

    @CrossOrigin
    @RequestMapping(value = "/users/getbuyerrating/{id}", method = RequestMethod.GET)
    public String getBuyerRate(@PathVariable Long id){
        return (userService.findBuyerRating(id));
    }

    @CrossOrigin
    @RequestMapping(value = "/users/getsellerrating/{id}", method = RequestMethod.GET)
    public String getSellerRate(@PathVariable Long id){
        return (userService.findSellerRating(id));
    }
}
