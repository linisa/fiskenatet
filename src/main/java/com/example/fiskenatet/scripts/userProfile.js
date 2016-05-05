$(document).ready(function () {
    var rootURL = 'http://localhost:8091/api';
    var currentUserID = sessionStorage.getItem("currentUser");
    var currentProductId = sessionStorage.getItem('currentProductId');
    var currentUser;
    var currentProduct;

    getUserById();

    $(document).on("click", "#lnkSetProductAsSold", function () {
        var currentProductID = $(this).data("value");
        getProductById(currentProductID, function (currentProduct) {
            productToHistoryJSON(currentProduct, function (JSONHistory) {
                moveSoldProductToHistory(JSONHistory);
            });
        })
    });
    
    $(document).on("click", "#lnkLogOut", function () {
        sessionStorage.removeItem('currentUser');
        location.href="../webcontent/index.html";
    });

    $(document).on("click", "#lnkEditProduct", function () {
        console.log("click, i editProduct");
        var currentProductID = $(this).data("value");
        getProductById(currentProductID, function(currentProduct){
            if(currentProduct['listOfBids'].length == 0){
                sessionStorage.setItem("productToEdit", currentProductID);
                location.href="../webcontent/editProduct.html"
            }else{
                alert("Misslyckades, Man kan inte uppdatera en annons någon budat på!");
            }
        });
    });

    $(document).on("click", "#lnkDeleteProduct", function () {
        console.log("click, i deleteproduct");
        var currentProductID = $(this).data("value");

        getProductById(currentProductID, function(currentProduct){
            if(currentProduct['listOfBids'].length == 0){
                deleteProduct(currentProduct.id);
            }else{
                alert("Misslyckades, Man kan inte ta bort en annons någon budat på!");
            }
        });
    });

    $(document).on("click", "#btnDeleteUser", function () {
        checkUserForActiveAuctions();
    });

    function checkUserForActiveAuctions() {
        if(currentUser['listOfProducts'].length == 0){
            deleteUser();
        }else{
            alert("Det går inte att ta bort ett konto med aktiva auktioner!");
        }
    }

    function moveSoldProductToHistory(JSONHistory){
        console.log("in moveSoldProductToHistory");
        $.ajax({
            type: 'POST',
            contentType:'application/json',
            url: rootURL + '/history',
            data: JSONHistory,
            success: function (data, textStatus, jgXHR) {
                //TODO: MAKE SÄTT BETYG

                console.log("GREAT SUCCESS!");
                deleteProduct(currentProductId);
            },
            error: function (jgXHR, textStatus, errorThrown) {
                console.log("send Error " +textStatus + "  " + errorThrown);
            }
        })
    }

    function productToHistoryJSON(currentProduct, callback) {
        var product = JSON.stringify({
            "owner" : {id: currentUserID},
            "description": currentProduct.description,
            "title": currentProduct.title,
            "startDate": currentProduct.startDate,
            "endDate": currentProduct.endDate,
            "soldFor": currentProduct.soldFor,
            "image": currentProduct.image
        });
        console.log(product);
        callback(product);
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

    function getProductById(currentProductId, callBack) {
        $.ajax({
            type: 'GET',
            contentType: 'application/json',
            url: rootURL + '/products/' + currentProductId,
            success: function (data, textStatus, jgXHR) {
                callBack(data);
            }
        });
    }

    function deleteProduct(currentProductId) {
        $.ajax({
            type: 'DELETE',
            contentType: 'application/json',
            url: rootURL + '/products/' + currentProductId,
            success: function (data, textStatus, jgXHR) {
                console.log("deleteProduct: " + data);
                sessionStorage.removeItem('currentProductId');
                location.reload();
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
           var listOfProducts = currentUser['listOfProducts'];
           productString+='<div class="OwnerProductObject"><div class="row"><div class="col-sm-4">';
           productString+='<img class="col-sm-12" src="' + listOfProducts[i].image + '">';
           productString+='</div><div class="col-sm-8">';
           productString+='<h3 id="ownerProductTitle">' + listOfProducts[i].title + '</h3>';
           productString+='<p class="ownerProductDescription">' + listOfProducts[i].description + '</p>';
           productString+='</div></div><div class="row"><div class="col-sm-6">';
           productString+='<p id="ownerProductStartDate">Datum tillagt: <br>' + listOfProducts[i].startDate + '</p>';
           productString+='<p id="ownerProductEndDate">Slutdatum: <br>' + listOfProducts[i].endDate + '</p>';
           productString+='</div><div class="col-sm-6">';
           productString+='<p id="ownerProductTotalBids">Totalt antal bud: <br>' + listOfProducts[i].listOfBids.length + '</p>';
           productString+='<p id="ownerProductHighestBid">Högsta bud: <br>' + listOfProducts[i].highestBid + '</p>';
           productString+='<p id="ownerProductBuyNowPrice">Utköpspris: <br>' + listOfProducts[i].buyNowPrice + '</p>';
           productString+='</div></div><div class="row"><div class="col-sm-4">';
           productString+='<a id="lnkEditProduct" href="#" data-value="'+ listOfProducts[i].id +'">Redigera annons</a>';
           productString+='</div><div class="col-sm-4">';
           productString+='<a id="lnkDeleteProduct"href="#" data-value="'+ listOfProducts[i].id +'">Ta bort annons</a></div>';
           if(listOfProducts[i].isSold){
               productString+='<div class="col-sm-4"><a id="lnkSetProductAsSold" href="#" data-value="'+ listOfProducts[i].id +'">Bekräfta köp</a></div>';
           }
           productString+='</div></div></div>';
       }
        $products.append(productString);
    }
});


