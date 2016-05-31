﻿><{{{^>	><{{{^>	><{{{^>	><{{{^> ><{{{^> ><{{{^> ><{{{^> ><{{{^> ><{{{^> ><{{{^> ><{{{^> ><{{{^> ><{{{^> ><{{{^> ><{{{^> ><{{{^>	><{{{^>	><{{{^>	><{{{^>	><{{{^>	><{{{^>	><{{{^>	><{{{^>	><{{{^>	><{{{^>	><{{{^>	><{{{^> 


#Fiskenatet


Index
-----

I.Introduction

II.Installation instructions

III.Configuration instructions

IV.User manual

V.File List

VI.Bugs&issues

VII.Trouble shooting

VIII.Credits

IX.Changelog

X.Contact



#Fiskenatet


I.Introduction
--------------

#Fiskenatet is auction site specialised in fish and seafood auctions, the target groups are retail, restaurants, hotels and occasionally private people.
The main idea with the site is to save the buyers time and effort. As a buyer its not requiered to attend the auction since you 
can monitor everything on your computer and that will save the buyer valuable time. #Fisken�tet also supplies with storage for up to 24 hours after the purchase so the fish stays fresh until pickup/delivery.
The auction winner can choose to pickup the winning auction or to get it delivered.



II.Installation instructions
-----------------------------

Download MySQL at	https://www.mysql.com/
Download JDK 8 at	http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html


Download IDEA at/or	https://www.jetbrains.com/idea/
			https://eclipse.org/	 		



III.Configuration instructions
-----------------------------

First you have to create a table in MySQL called Fiskenatet. Its fundamental since everything from login details to auction details is stored in the table.

II.Configuration instructions
-----------------------------

First you have to create a table in MySQL called Fiskenatet. Its fundamental since everything from login details to auction details is stored in the table.


III.Installation instructions
-----------------------------

>>>>>>> 3a16ae1625c17a036d6a06b8d307805e2063cdc4



IV.User manual
--------------

Start the application by running the Application.java file in your IDEA (IntelliJ,Eclipse,etc.etc)
Type in this address (http://localhost:63342/Fiskenatet/com/example/fiskenatet/webcontent/index.html) in your web browser to get to the main page

Register a account:

Click Registrera on the menubar to get to the create user page. Fill in the form with required information and press the Registrera button on the bottom of the page.


Edit account:

If you want to edit your account information, press Profil on the menubar and you will be directed to a page with your account information.
On this page you press the Redigera profil button and you will be directed to a page with a form which is filled with your information. Change the old info to the new
info and confirm by typing your password in the Nytt l�senord field and Upprepa nytt l�senord field then click Uppdatera konto button in the bottom of the page.


Delete account:

If you want to delete your account, press Profil on the menubar and you will be directed to a page with your account information.
On this page you press the Ta bort profil button and your account will be deleted.
An account with active auctions can not be removed.


Create an auction:

If you want to create a auction press Skapa auktion on the menubar and you will be directed to a page. On this page you first have to choose a category of the product, to that you click
on the (V�lj kategori) dropdown under Kategori and choose one of the options. Next step is to type in a fitting title for the auction in the (Produkttitel) field, after that its time to choose
a image for your product with the radiobuttons (Ladda upp en egen bild!) or (V�lj en bild fr�n v�rat utbud!). You can either choose to upload a own image by typing the image adrress in (Bild URL) field.  
(Ladda upp en egen bild!) or choose one of the already existing images in the dropdown menu which appears when you mark the (V�lj en bild fr�n v�rat utbud!) radiobutton. Next step is to write a 
description of your product in the (Beskrivning) field. After that is time to type in starting price of your product and that is set in the Startpris field. The last detail 
in creating your auction is optional and that is a buyout price which is set in the (K�p nu pris) field, if you don�t want to have a buyout price leave the field empty. Last step when all this is done
is pressing the (Starta Auktion) button and your auction will be created.


Find an auctions:

To find an auction you can either choose a category on the (V�lj kategori) dropdown in the menubar or you can search for the product in the searchfield.


Bid on an auction:


If you want to submit a bid on a auction click on the auction and you will be directed to a page regarding that specifik auction. Here you can see all the details for the auction (expiry date, starting price, 
highest bid, etc, etc) and post a bid or buyout the auction if the seller has set a buyout price. If you want to submit a bid, enter your bid in the field above the green (L�gg ett bud) button and press the 
button(L�gg ett bud). If you want to buyout the auction for the buyout price press the (K�p nu:) button above the textfield, this button will only be visible if a buyout price is set by the seller. When you
press the buyout button you will be directed to a page where you have to choose payment method. The options are (Betala med Swish) or (Betala med PayPal) and will be displayed as 2 buttons. When you click on 
the Swish button a dropdown will unfold where you can see the Phonenumber(telefonnummer) to the seller and this is the same number that you make your Swish deposit to. When the Swish deposit is done, you can 
rate the seller with the 5 star rating and click on the (Bekr�fta k�p) button to confirm. When this is done the seller has to confirm that he/she has received the payment, when that is done you will receive a
confirmation mail.


Edit an auction:

If you want to edit an auction, press Profil on the menubar and you will be directed to a page with your account information. On this page you press the (Redigera annons) button and you will be directed to a page 
with a form which is filled with the existing information. Change the old info to the new info and confirm by clicking on the (Spara �ndringar) button. An auction with active bids can not be edited.


Delete an auction:     


If you want to delete a auction, press Profil on the menubar and you will be directed to a page with your account information.
On this page you press the (Ta bort annons) button and your auction will be deleted.
An auction with active bids can not be removed.





V. File List

------------

JavaScript:

about.js	
addProduct.js
addUser.js
bidHistory.js
confirmPurchase.js
editProduct.js
editUser.js
index.js
productDetails.js
userProfile.js

Java:

BidController.java
HistoryController.java
ProductController.java
UserController.java

MailHandler.java
UserRating.java
Validation.java

BidModel.java
HistoryModel.java
ProductModel.java
UserModel.java

BidRepository.java
HistoryRepository.java
ProductRepository.java
UserRepository.java

BidService.java
HistoryService.java
ProductService.java
UserService.java

TimerHandler.java

Application.java

BidTest.java
TestBidDal.java
TestBidModel.java

MailHandlerTest.java

ProductTest.java
TestProductDal.java
TestproductModel.java

UserRatingTest.java

TestUserDal.java
TestUserModel.java
UserTest.java

TestValidation.java

BidBuilder.java
BidControllerTest.java
HistoryBuilder.java
HistoryControllerTest.java
ProductBuilder.java
ProductControllerTest.java
UserBuilder.java
UserControllerTest.java

Class:

BidTest.class
TestBidDal.class
TestBidModel.class

MailHandlerTest.class

ProductTest.class
TestProductDal.class
TestProductModel.class

UserRatingTest.class

TestUserDal.class
TestUserModel.class
UserTest.class

TestValidation.class

BidBuiler.class
BidControllerTest.class
HistoryBuilder.class
HistoryControllerTest.class
ProductBuilder.class
ProductControllerTest.class
UserBuilder.class
UserControllerTest.class

Html:

about.html
addProduct.html
addUser.html
bidHistory.html
confirmPurchase.html
editProduct.html
editUser.html
index.css
index.html
productDetails.html
userProfile.html



VI.Bugs&issues
---------------
When updating a user, if the user already has bought/won an ad (eg. the user has his username listed under buyer_username
in the history table in the database.), then the user will be prompted that the username is already in use even if the user
don't want to change his current username.



VII.Trouble shooting
--------------------

Nothing to report.
	



VIII.Credits
------------
Creds to all the staff at V�llagat except the buffe nazi. Buss 173 for departing 3 times in a hour. 
The "Kvitto?" cashier at the kiosk close to school. HBO for releasing the 6th season of Game of Thrones 
so we could have the GoT lunch on mondays. Joel Nilsson for supplying us with his mail address and Last 
but not least a big thanks to Vitas for making the song 7th element which has made this project more fun 
to work on. 



IX.Changelog
------------
Error-handling account registration.
Error-handling product registration.
Error-handling product image.
Create a timer for the auctions.
Handle auctions whitout bid.
Error-handling account logins.
Error-handling confirm purchase.
Error-handling end date for auctions:
Error-handling category listing.
Error-handling bid history.
Error-handling seller/buyer rating.
Create a about page.
Paypal as deposit option.

 
X.Contact
---------

Report bugs and other issues to fiskenaetet@gmail.com






><{{{^>	><{{{^>	><{{{^>	><{{{^> ><{{{^> ><{{{^> ><{{{^> ><{{{^> ><{{{^> ><{{{^> ><{{{^> ><{{{^> ><{{{^> ><{{{^> ><{{{^> ><{{{^>	><{{{^>	><{{{^>	><{{{^>	><{{{^>	><{{{^>	><{{{^>	><{{{^>	><{{{^>	><{{{^>	><{{{^>	><{{{^> 










	



















	



 


