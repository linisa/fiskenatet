package com.example.fiskenatet.main;

import com.example.fiskenatet.models.UserModel;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import static jdk.nashorn.internal.objects.NativeString.substring;

/**
 * Created by nordi_000 on 2016-04-28.
 */
public class UserRating {

    /**
     * Funktion för att få ut medelbetyget hos en användare, antingen som säljare
     * eller som köpare. Input till funktionen är en sträng bestående av siffror
     * och som retur värde får man tillbaka medelvärdet av strängen.
     * @param currentRating = skicka in userModel.getRatingSeller eller Buyer!
     * @return tillbaka får du en sträng som är snittvärdet (betyg).
     */
    public String getUserAverageRating(String currentRating) {
        int totalRatingPoints = 0;
        String selectedNumber;
        String averageRating="";

        for(int i = 0; i < currentRating.length(); i++) {
            selectedNumber = currentRating.substring(i,i+1);
            totalRatingPoints += Integer.parseInt(selectedNumber);
        }
        averageRating = Integer.toString(totalRatingPoints / currentRating.length());

        return averageRating;
    }
}
