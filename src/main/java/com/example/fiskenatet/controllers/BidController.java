package com.example.fiskenatet.controllers;

import com.example.fiskenatet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class BidController {

    @Autowired
    private UserRepository userRepository;
}
