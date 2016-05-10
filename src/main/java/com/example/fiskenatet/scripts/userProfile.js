$(document).ready(function () {
    var rootURL = 'http://localhost:8091/api';
    var currentUserID = sessionStorage.getItem("currentUser");
    var currentProductId = sessionStorage.getItem('currentProductId');
    var currentUser;
    var currentProduct;

    getUserById(function (currentUser) {
        checkCategory();
    });


    function checkCategory() {
        
        var category = document.getElementById("selectCategory");
        var categoryChoice = category.options[category.selectedIndex].value;
        if(categoryChoice == 0){
            console.log("ingen kategori vald");
            populateUserProducts(currentUser['listOfProducts']);
        }else{
            console.log("kategori vald " + categoryChoice);
            //populateUserProducts(categoryChoice);
            //listCategory(categoryChoice);

        }

    }

    /*function listCategory(currentProduct, callback) {
        console.log("I listcategory");
        $.ajax({
            type: 'GET',
            contentType: 'application/json',
            url: rootURL + '/products/byownerandcategory/' + currentUserID + "/" + currentProduct,
            data: callback,
            success: function (data, textStatus, jgXHR) {
                populateUserProducts(currentUser['listOfProducts']);

            },
            error: function(jgXHR, textStatus, errorThrown) {
                //alert('getCustomer error: ' + textStatus);
                console.log("ListCategory error: " + textStatus);
            }
        });
    }*/


    /*function listCategory(categoryChoice){

        var productList = currentUser['listOfProducts'];
        console.log("productlist: " + productList[0].title);
        var productListByCategory = [];
        for (var i = 0; i < productList.length; i++){
            console.log("i loopen");
            if(productList[i].category == categoryChoice){
                productListByCategory[i] = productList[i];
                console.log("product added");
                console.log(productListByCategory[i]);
            }
        }
        populateUserProducts(productListByCategory);
    }*/

    $(document).on("click", "#selectCategory", function () {
        checkCategory();
    });

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

    function getUserById(callback) {
        $.ajax({
            type: 'GET',
            contentType: 'application/json',
            url: rootURL + '/users/' + currentUserID,
            success: function (data, textStatus, jgXHR) {
                currentUser = data;
                callback(data);
                populateUserInfo();
                populateUserProducts(currentUser['listOfProducts']);
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

    function populateUserProducts(listOfProducts) {
        document.getElementById('productList').innerHTML = "";
        $products = $('#productList');
        var productString="";
        var smallLimit = 90;
       for(i = 0; i < currentUser['listOfProducts'].length; i++){
           console.log("popUserProd: " + listOfProducts[i]);
           listOfBids = listOfProducts[i]['listOfBids'];

           productString+='<div class="OwnerProductObject"><div class="row"><div class="col-sm-4">';
           productString+='<img class="col-sm-12" src="' + listOfProducts[i].image + '">';
           productString+='</div><div class="col-sm-8">';
           productString+='<h3 id="ownerProductTitle">' + listOfProducts[i].title + '</h3>';
           productString+='<p class="ownerProductDescription">' + listOfProducts[i].description + '</p>';
           productString+='</div></div><div class="row"><div class="col-sm-6">';
           productString+='<p id="ownerProductStartDate">Datum tillagt: <br>' + listOfProducts[i].startDate + '</p>';
           productString+='<p id="ownerProductEndDate">Slutdatum: <br>' + listOfProducts[i].endDate + '</p>';
           productString+='<p id="ownerProductCategory">Kategori: <br>' + listOfProducts[i].category + '</p>';
           productString+='</div><div class="col-sm-6">';
           productString+='<p id="ownerProductTotalBids">Totalt antal bud: <br>' + listOfProducts[i].listOfBids.length + '</p>';

           if(listOfBids.length != 0){
               listOfBids.sort(function (a, b) {
                   return b.amount - a.amount;
               });
               productString+='<p id="ownerProductHighestBid">Högsta bud: <br>' +  listOfBids[0].amount + " kr"  + '</p>';
           }else{
               productString+='<p id="ownerProductHighestBid">Högsta bud: <br>' +  listOfProducts[i].startPrice + " kr" + '</p>';
           }

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


