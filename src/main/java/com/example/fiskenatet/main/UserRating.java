package com.example.fiskenatet.main;

import com.example.fiskenatet.models.UserModel;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import static jdk.nashorn.internal.objects.NativeString.substring;

/**
 * Created by nordi_000 on 2016-04-28.
 */
public class UserRating {

    // Från backend till frontend. Hämtar betyg från databasen och räknar
    // snittbetyget och retunerar detta som en string.
    public String getUserAverageRating(String ratingStringFromDB) {

        double totalRatingPoints = 0;
        String selectedNumber;
        double doubleAverageRating;
        String stringAverageRating="";
        if(ratingStringFromDB.equals("No rating yet")) {
            stringAverageRating = "No rating yet";
            return stringAverageRating;
        } else {
            for (int i = 0; i < ratingStringFromDB.length(); i++) {
                selectedNumber = ratingStringFromDB.substring(i, i + 1);
                totalRatingPoints += Double.parseDouble(selectedNumber);
            }
            doubleAverageRating = (totalRatingPoints / ratingStringFromDB.length());
            stringAverageRating = Double.toString(Math.round(doubleAverageRating));
            stringAverageRating = stringAverageRating.substring(0, 1);
            return stringAverageRating;
        }
    }


    // Input från frontend till backend. Lägger på det nya betyget på dom andra.
    public void setBuyerRatingForDatabase(UserModel userModel, String oldRating, String newRating) {
        if(oldRating.equals("No rating yet")){
                userModel.setRatingAsBuyer(newRating);
        }else {
            userModel.setRatingAsBuyer(oldRating + newRating);
        }
    }

    // Input från frontend till backend. Lägger på det nya betyget på dom andra.
    public void setSellerRatingForDatabase(UserModel userModel, String oldRating, String newRating) {
        if(oldRating.equals("No rating yet")){
            userModel.setRatingAsSeller(newRating);
        }else {
            userModel.setRatingAsSeller(oldRating + newRating);
        }
    }

}
