package com.example.fiskenatet.services;

import com.example.fiskenatet.models.UserModel;
import com.example.fiskenatet.repositories.UserRepository;
import org.hibernate.sql.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import java.util.List;

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

    public UserModel getUserByName(String userName) {
        return (UserModel) userRepository.findUserByUserName(userName);
    }

    public List<UserModel> getAllUsers() {
        return (List<UserModel>) userRepository.findAll();

    }
}
