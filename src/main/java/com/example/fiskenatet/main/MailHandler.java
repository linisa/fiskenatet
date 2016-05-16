package com.example.fiskenatet.main;

import com.example.fiskenatet.models.BidModel;
import com.example.fiskenatet.models.ProductModel;
import com.example.fiskenatet.models.UserModel;
import com.example.fiskenatet.repositories.BidRepository;
import com.example.fiskenatet.repositories.UserRepository;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailHandler {

    public Session setUpMail() {

        final String username = "fiskenaetet@gmail.com";
        final String password = "fisk12345";

        Properties properties = new Properties();
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        return session;
    }

    public void sendWinnerNotification(UserModel owner, UserModel winner, ProductModel soldProduct) {
        try {
            List<BidModel> bidList = soldProduct.getListOfBids();
            BidModel highestBid = bidList.get(bidList.size() - 1);
            Message message = new MimeMessage(setUpMail());
            message.setFrom(new InternetAddress("fiskenaetet@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(winner.getEmail()));
            message.setSubject("Du vann en auktion!");
            message.setText("Grattis " + winner.getFirstName() + "! Du vann budgivningen på " + owner.getUserName() + "'s " + soldProduct.getTitle()
                    + "\n" + "Slutpris: " + highestBid.getAmount() + ":-"
                    + "\n" + "Logga in på din sida för att betala."
                    + "\n" + "Hälsningar Fiskenätet!");

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendSellerNotification(UserModel owner, UserModel winner, ProductModel soldProduct) {
        try {
            List<BidModel> bidList = soldProduct.getListOfBids();
            BidModel highestBid = bidList.get(bidList.size() - 1);
            Message message = new MimeMessage(setUpMail());
            message.setFrom(new InternetAddress("fiskenaetet@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(owner.getEmail()));
            message.setSubject("Din annons har sålts!");
            message.setText("Grattis " + owner.getFirstName() + "! Din annons '" + soldProduct.getTitle() + "' har sålts för " + highestBid.getAmount() + ":-"
                    + "\n" + "Köparen är: " + winner.getUserName()
                    + "\n" + "Logga in på din sida för att se mer information."
                    + "\n" + "Hälsningar Fiskenätet!");

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendNewBidNotification(ProductModel currentProduct, BidModel bidModel, UserModel lastBidder) {

        try {

            Message message = new MimeMessage(setUpMail());
            message.setFrom(new InternetAddress("fiskenaetet@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(lastBidder.getEmail()));
            message.setSubject("Du blev överbudad");
            message.setText("Någon har budat över på '" + currentProduct.getTitle() + "'"
                    + "\n" + "Skynda dig in för att lägga ett nytt bud!"
                    + "\n" + "Nuvarande högsta bud är: " + bidModel.getAmount() + ":-"
                    + "\n" + "Hälsningar Fiskenätet!");

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendLoserNotification(ProductModel currentProduct, UserModel loser, UserModel seller, BidModel endBid) {
        try {

            Message message = new MimeMessage(setUpMail());
            message.setFrom(new InternetAddress("fiskenaetet@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(loser.getEmail()));
            message.setSubject("Du förlorade en budgivning");
            message.setText("Du förlorade budgivningen på '" + seller.getUserName() + "'s " + currentProduct.getTitle() + "'"
                    + "\n" + "Slutpriset blev: " + endBid.getAmount() + ":-"
                    + "\n" + "Lycka till nästa gång!"
                    + "\n" + "Hälsningar Fiskenätet!");

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean controlUserMail(String email) {
        boolean validMail;
       try {
           Message message = new MimeMessage(setUpMail());
           message.setFrom(new InternetAddress("fiskenaetet@gmail.com"));
           message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
           message.setSubject("Välkommen till Fiskenätet");
           message.setText("Tack för din registrering hos Fiskenätet"
                   + "\n" + "Detta är ett verifikationsmejl"
                   + "\n" + "Hälsningar Fiskenätet!");

           Transport.send(message);

           validMail = true;
       } catch(MessagingException e){
           validMail = false;
       }

        return validMail;
    }
}