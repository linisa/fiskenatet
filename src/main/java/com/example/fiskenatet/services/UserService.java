package com.example.fiskenatet.services;

import com.example.fiskenatet.models.ProductModel;
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

    // skapa användare
    public void saveUser(UserModel userModel) {
        userRepository.saveAndFlush(userModel);
    }

    // hämta specifik användare med ID
    public UserModel getUser(Long id) {
        return (UserModel) userRepository.getOne(id);
    }

    // hämta specifik användare med USERNAME
    public UserModel getUserByName(String userName) {
        return (UserModel) userRepository.findUserByUserName(userName);
    }

    // hämta alla användare
    public List<UserModel> getAllUsers() {
        return (List<UserModel>) userRepository.findAll();

    }

    // delete användar med ID
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    // uppdatera specifik användare med ID
    public void updateUser(Long id, UserModel userModel) {
        UserModel userToUpdate = userRepository.getOne(id);
        userToUpdate.setFirstName(userModel.getFirstName());
        userToUpdate.setLastName(userModel.getLastName());
        userToUpdate.setEmail(userModel.getEmail());
        userToUpdate.setMobileNumber(userModel.getMobileNumber());
        userToUpdate.setPassword(userModel.getPassword());
        userRepository.saveAndFlush(userToUpdate);
    }


}
