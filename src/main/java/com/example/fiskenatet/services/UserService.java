package com.example.fiskenatet.services;

import com.example.fiskenatet.main.UserRating;
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
    public UserModel findUser(Long id) {
        return (UserModel) userRepository.getOne(id);
    }

    // hämta specifik användare med USERNAME
    public UserModel findUserByUserName(String userName) {
        return (UserModel) userRepository.findUserByUserName(userName);
    }

    // hämta alla användare
    public List<UserModel> findAllUsers() {
        return (List<UserModel>) userRepository.findAll();

    }

    // delete användar med ID
    public void deleteUserInDatabase(Long id) {
        userRepository.delete(id);
    }

    // uppdatera specifik användare med ID
    public void updateUserInDatabase(Long id, UserModel userModel) {
        UserModel userToUpdate = userRepository.getOne(id);

        userToUpdate.setFirstName(userModel.getFirstName());
        userToUpdate.setLastName(userModel.getLastName());
        userToUpdate.setEmail(userModel.getEmail());
        userToUpdate.setMobileNumber(userModel.getMobileNumber());
        userToUpdate.setPassword(userModel.getPassword());
        userRepository.saveAndFlush(userToUpdate);
    }


    public void saveBuyerRating(Long id, UserModel userModel){
        UserModel userToUpdate = userRepository.getOne(id);
        String oldRating = userToUpdate.getRatingAsBuyer();   // gamla betyget
        String newRateToAdd = userModel.getRatingAsBuyer();  // nya betyget
        UserRating userRating = new UserRating();
        userRating.setBuyerRatingForDatabase(userToUpdate, oldRating, newRateToAdd);
        userRepository.saveAndFlush(userToUpdate);
    }

    public void saveSellerRating(Long id, UserModel userModel){
        UserModel userToUpdate = userRepository.getOne(id);
        String oldRating = userToUpdate.getRatingAsSeller();   // gamla betyget
        String newRateToAdd = userModel.getRatingAsSeller();  // nya betyget
        UserRating userRating = new UserRating();
        userRating.setSellerRatingForDatabase(userToUpdate, oldRating, newRateToAdd);
        userRepository.saveAndFlush(userToUpdate);
    }

    public String findBuyerRating(Long id){
        UserModel userModel = userRepository.getOne(id);
        String buyersFullRating = userModel.getRatingAsBuyer();
        UserRating userRating = new UserRating();
        String averageRating = userRating.getUserAverageRating(buyersFullRating);
        return averageRating;
    }

    public String findSellerRating(Long id){
        UserModel userModel = userRepository.getOne(id);
        String sellersFullRating = userModel.getRatingAsSeller();
        UserRating userRating = new UserRating();
        String averageRating = userRating.getUserAverageRating(sellersFullRating);
        return averageRating;
    }


}
