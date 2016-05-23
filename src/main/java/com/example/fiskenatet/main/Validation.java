package com.example.fiskenatet.main;

import com.example.fiskenatet.Application;
import com.example.fiskenatet.models.HistoryModel;
import com.example.fiskenatet.models.ProductModel;
import com.example.fiskenatet.models.UserModel;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Linus on 2016-05-18.
 */
public class Validation {

    Logger log = Logger.getLogger(Application.class.getName());

    public String validateProductInput(ProductModel productModel){
        String checkProduct = "OK";

        if(productModel.getTitle().equals("")||productModel.getTitle().equals(" ")){
            checkProduct = "Produkttitel saknas";
        }
        if(productModel.getDescription().equals("")||productModel.getDescription().equals(" ")){
            checkProduct = "Produktbeskrivning saknas";
        }
        if(productModel.getCategory().equals("0")){
            checkProduct = "Välj en produktkategori";
        }
        if(controlProductImage(productModel) == false){
            checkProduct = "Välj en produktbild som en URL. Tillåtna format: JPEG, JPG, GIF, PNG";
        }
        if(productModel.getStartPrice() < 0){
            checkProduct = "Utropspriset kan inte vara lägre än 0";
        }
        if(productModel.getBuyNowPrice() != 0 && productModel.getBuyNowPrice() < productModel.getStartPrice()){
            checkProduct = "Köp-nu-priset måste vara högre än utropspriset";
        }
        log.info("Called method 'validateProductInput' that returned string: " + checkProduct);
        return checkProduct;
    }

    private boolean controlProductImage(ProductModel productModel) {
        boolean imageIsGood;
        if(productModel.getImage().contains("../resources/")){
            imageIsGood = true;
        }
        else if(productModel.getImage().endsWith(".jpeg") || productModel.getImage().endsWith(".jpg")
                || productModel.getImage().endsWith(".gif") || productModel.getImage().endsWith(".png")) {
            try {
                System.out.println("open connection " +  productModel.getImage());
                URL imageUrl = new URL(productModel.getImage());
                URLConnection connection = imageUrl.openConnection();
                connection.connect();
            } catch (MalformedURLException e) {
                System.out.println("cant open connection " +  productModel.getImage() + " " + e);
                imageIsGood = false;
                return imageIsGood;
            } catch (IOException e) {
                System.out.println("cant open connection " +  productModel.getImage() + " " + e);
                imageIsGood = false;
                return imageIsGood;
            }
            imageIsGood = true;
        }else{
            imageIsGood = false;
        }
        log.info("Called method 'controlProductImage' that returned boolean: " + imageIsGood);
        return imageIsGood;
    }

    public String validateUserNameAndEmail(List<UserModel> userList, List<HistoryModel> historyList, UserModel userModel){
        String checkUser = "OK";
        for(UserModel compareUser : userList) {
            if(compareUser.getUserName().equals(userModel.getUserName())){
                checkUser = "Användarnamnet är upptaget";
            }
            if(compareUser.getEmail().equals(userModel.getEmail())){
                checkUser = "E-postadressen är redan registrerad";
            }
        }
        for(HistoryModel compareBuyer : historyList){
            if(compareBuyer.getBuyerUsername().equals(userModel.getUserName())){
                checkUser = "Användarnamnet är upptaget";
            }
        }
        log.info("Called method 'validateUserNameAndEmail' that returned string: " + checkUser);
        return checkUser;
    }

    public String controlUserInput(UserModel userModel, String checkUser){
        if(userModel.getFirstName().equals("")||userModel.getFirstName().equals(" ")){
            checkUser = "Förnamn saknas";
        }if(userModel.getLastName().equals("")||userModel.getLastName().equals(" ")){
            checkUser = "Efternamn saknas";
        }if(userModel.getUserName().equals("")||userModel.getUserName().equals(" ")){
            checkUser = "Användarnamn saknas";
        }if(userModel.getEmail().equals("")||userModel.getEmail().equals(" ")){
            checkUser = "Ange en e-postadress";
        }if(userModel.getMobileNumber().equals("")||userModel.getMobileNumber().equals(" ")){
            checkUser = "Telefonnummer saknas";
        }if(userModel.getAddress().equals("")||userModel.getAddress().equals(" ")){
            checkUser = "Ange din postadress";
        }if(userModel.getPostCode().equals("")||userModel.getPostCode().equals(" ")){
            checkUser = "Ange ditt postnummer";
        }if(userModel.getPaymentMethod() == 0) {
            checkUser = "Välj ett betalningsalternativ";
        }if (userModel.getPaymentMethod() > 1 && userModel.getPayPalUserName().equals("")) {
            checkUser = "Ange ditt Paypal.Me-namn";
        }
        log.info("Called method 'controlUserInput' that returned string: " + checkUser);
        return checkUser;
    }
}
