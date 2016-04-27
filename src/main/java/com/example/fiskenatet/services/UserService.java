package com.example.fiskenatet.services;

import com.example.fiskenatet.models.UserModel;
import com.example.fiskenatet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Erik on 2016-04-27.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(UserModel userModel) {
        userRepository.saveAndFlush(userModel);
    }
}
