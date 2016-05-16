package com.example.fiskenatet.services;

import com.example.fiskenatet.logging.Logging;
import com.example.fiskenatet.main.MailHandler;
import com.example.fiskenatet.main.UserRating;
import com.example.fiskenatet.models.UserModel;
import com.example.fiskenatet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private MailHandler mailHandler = new MailHandler();

    Logging logging = new Logging();
    Logger log = logging.createLog();

    // skapa användare
    public void saveUser(UserModel userModel) {
        userRepository.saveAndFlush(userModel);
        log.info("New user created with ID = " +userModel.getId());
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
        log.info("User deleted with ID = " +id);
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

    public void saveBuyerRating(Long id, String addRating){
        UserModel userToUpdate = userRepository.getOne(id);
        String oldRating = userToUpdate.getRatingAsBuyer();   // gamla betyget
        UserRating userRating = new UserRating();
        userRating.setBuyerRatingForDatabase(userToUpdate, oldRating, addRating);
        userRepository.saveAndFlush(userToUpdate);
    }

    public void saveSellerRating(Long id, String addRating){
        UserModel userToUpdate = userRepository.getOne(id);
        String oldRating = userToUpdate.getRatingAsSeller();   // gamla betyget
        UserRating userRating = new UserRating();
        userRating.setSellerRatingForDatabase(userToUpdate, oldRating, addRating);
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

    public String checkIfUserExistsInDatabase(UserModel userModel){
        String checkUser = "OK";
        List<UserModel> userList = userRepository.findAll();
        for(UserModel compareUser : userList) {
            if(compareUser.getUserName().equals(userModel.getUserName())){
                checkUser = "User name not available";

            }if(compareUser.getEmail().equals(userModel.getEmail())){
                checkUser = "Mail already registered";
            }
        }
        return checkUser;
    }
    public String controlUserInput(UserModel userModel){
        String checkUser = "OK";
        if(userModel.getFirstName().equals("")||userModel.getFirstName().equals(" ")){
            checkUser = "First name required";
        }if(userModel.getLastName().equals("")||userModel.getLastName().equals(" ")){
            checkUser = "Last name required";
        }if(userModel.getUserName().equals("")||userModel.getUserName().equals(" ")){
            checkUser = "User name required";
        }if(mailHandler.controlUserMail(userModel.getEmail()) == false){
            checkUser = "Enter a valid e-mail address";
        }if(userModel.getMobileNumber().equals("")||userModel.getMobileNumber().equals(" ")){
            checkUser = "Phone number required";
        }
        return checkUser;
    }


}
