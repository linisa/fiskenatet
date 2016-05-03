$(document).ready(function () {
    var rootURL = 'http://localhost:8091/api';
    var currentUserID = sessionStorage.getItem("currentUser");
    var currentUser;

    getUserById();
    
    $(document).on("click", "#lnkLogOut", function () {
        sessionStorage.removeItem('currentUser');
        location.href="../webcontent/index.html";
    });

    $(document).on("click", "#lnkEditProduct", function () {

        //TODO: MAKE FUNCTION
    });

    $(document).on("click", "#lnkDeleteProduct", function () {
        checkAuctionForBids();
    });

    $(document).on("click", "#btnDeleteUser", function () {
        checkUserForActiveAuctions();
    });

    function checkAuctionForBids(){
        var currentProductId = $(this).data("value");
        var currentProduct = getProductById(currentProductId);
        if(currentProduct['listOfBids'].length == 0){
            deleteProduct(currentProductId);
        }else{
            alert("Misslyckades, Man kan inte ta bort en annons någon budat på!");
        }
    }
    function checkUserForActiveAuctions() {
        if(currentUser['listOfProducts'].length == 0){
            deleteUser();
        }else{
            alert("Det går inte att ta bort ett konto med aktiva auktioner!");
        }
    }
    
    function deleteUser() {
        $.ajax({
            type: 'DELETE',
            contentType: 'application/json',
            url: rootURL + '/users/' + currentUserID,
            success: function (data, textStatus, jgXHR) {
                sessionStorage.removeItem('currentUser');
                location.href="../webcontent/index.html";
            }
        });
    }

    function deleteProduct(currentProductId) {
        $.ajax({
            type: 'DELETE',
            contentType: 'application/json',
            url: rootURL + '/products/' + currentProductId,
            success: function (data, textStatus, jgXHR) {
                sessionStorage.removeItem('currentProductId');
                location.reload();
            }
        });
    }
    function getProductById(currentProductId) {
        $.ajax({
            type: 'GET',
            contentType: 'application/json',
            url: rootURL + '/products/' + currentProductId,
            success: function (data, textStatus, jgXHR) {
                currentUser = data;
                populateUserInfo();
                populateUserProducts();
            }
        });
    }


    function getUserById() {
        $.ajax({
            type: 'GET',
            contentType: 'application/json',
            url: rootURL + '/users/' + currentUserID,
            success: function (data, textStatus, jgXHR) {
                currentUser = data;
                console.log(data);
                populateUserInfo();
                populateUserProducts();
            }
        });
    }

    function populateUserInfo() {
        document.getElementById('upUserName').innerHTML =currentUser.userName;
        document.getElementById('upFirstName').innerHTML =currentUser.firstName;
        document.getElementById('upLastName').innerHTML =currentUser.lastName;
        document.getElementById('upEmail').innerHTML =currentUser.email;
        document.getElementById('upMobileNumber').innerHTML =currentUser.mobileNumber;
        //document.getElementById('upRatingAsSeller').innerHTML =currentUser[''];
        //document.getElementById('upRatingAsBuyer').innerHTML =currentUser[''];
    }

    
    function populateUserProducts() {
        $products = $('#productList');
        var productString="";
        var smallLimit = 90;
       for(i = 0; i < currentUser['listOfProducts'].length; i++){
           productString+='<div class="OwnerProductObject"><div class="row"><div class="col-sm-4">';
           productString+='<img class="col-sm-12" src="' + currentUser['listOfProducts'][i].image + '">';
           productString+='</div><div class="col-sm-8">';
           productString+='<h3 id="ownerProductTitle">' + currentUser['listOfProducts'][i].title + '</h3>';
           productString+='<p class="ownerProductDescription">' + currentUser['listOfProducts'][i].description + '</p>';
           productString+='</div></div><div class="row"><div class="col-sm-6">';
           productString+='<p id="ownerProductStartDate">Datum tillagt: <br>' + currentUser['listOfProducts'][i].startDate + '</p>';
           productString+='<p id="ownerProductEndDate">Slutdatum: <br>' + currentUser['listOfProducts'][i].endDate + '</p>';
           productString+='</div><div class="col-sm-6">';
           productString+='<p id="ownerProductTotalBids">Totalt antal bud: <br>' + currentUser['listOfProducts'][i].listOfBids.length + '</p>';
           productString+='<p id="ownerProductHighestBid">Högsta bud: <br>' + currentUser['listOfProducts'][i].highestBid + '</p>';
           productString+='<p id="ownerProductBuyNowPrice">Utköpspris: <br>' + currentUser['listOfProducts'][i].buyNowPrice + '</p>';
           productString+='</div></div><div class="row"><div class="col-sm-6">';
           productString+='<a id="lnkEditProduct" href="#" data-value="'+ currentUser['listOfProducts'][i].id +'">Redigera annons</a>';
           productString+='</div><div class="col-sm-6">';
           productString+='<a id="lnkDeleteProduct"href="#" data-value="'+ currentUser['listOfProducts'][i].id +'">Ta bort annons</a>';
           productString+='</div></div></div>';

               
       }
        $products.append(productString);
    }

});


