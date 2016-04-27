package com.example.fiskenatet.services;

import com.example.fiskenatet.models.UserModel;
import com.example.fiskenatet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;

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

    public UserModel getUser(Long id) {
        return (UserModel) userRepository.getOne(id);
    }

    public List<UserModel> getAllUsers() {
        return (List<UserModel>) userRepository.findAll();
    }
}
