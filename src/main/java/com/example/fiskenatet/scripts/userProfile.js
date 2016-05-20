var rootURL = 'http://localhost:8091/api';
var currentUserID;
var currentProductId = sessionStorage.getItem('currentProductId');
var currentUserName;
var currentUser;
var currentProduct;

CheckIfLoggedIn();
function CheckIfLoggedIn() {
    currentUserID = sessionStorage.getItem("currentUser");
    currentUserName = sessionStorage.getItem('currentUserName');
    if(currentUserID == null){
        location.href="../webcontent/index.html";
    }
}

$(document).ready(function () {



    getUserById(function (currentUser) {
        checkCategory();
        document.getElementById('lnkProfileUserName').innerHTML = "Inloggad som: " + currentUserName;
    });


    function checkCategory() {
        
        var category = document.getElementById("selectCategory");
        var categoryChoice = category.options[category.selectedIndex].value;
        if(categoryChoice == 0){
            console.log("ingen kategori vald");
            populateUserProducts(currentUser['listOfProducts']);
        }else{
            console.log("kategori vald " + categoryChoice);
            listCategory(categoryChoice);
        }
    }

    $(document).on("click", "#selectCategory", function () {
        checkCategory();
    });


    function listCategory(categoryChoice) {
        console.log("I listcategory");
        $.ajax({
            type: 'GET',
            contentType: 'application/json',
            url: rootURL + '/products/byownerandcategory/' + categoryChoice + "/" + currentUserID,
            success: function (data, textStatus, jgXHR) {
                populateUserProducts(data);
            },
            error: function(jgXHR, textStatus, errorThrown) {
                //alert('getCustomer error: ' + textStatus);
                console.log("ListCategory error: " + textStatus);
            }
        });
    }
    

    $(document).on("click", "#lnkSetProductAsSold", function () {
        var currentProductID = $(this).data("value");

        getProductById(currentProductID, function (currentProduct) {
            setBuyerRating(currentProduct);
            productToHistoryJSON(currentProduct, function (JSONHistory) {
                moveSoldProductToHistory(JSONHistory);
            });
        })
    });
    
    $(document).on("click", "#lnkLogOut", function () {
        sessionStorage.removeItem('currentUser');
        sessionStorage.removeItem('currentUserName');
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

    function setBuyerRating(currentProduct) {
        var buyerRating = $("input[type='radio'][name='rating']:checked").val();
        console.log("setBuyerRating " + buyerRating);
        $.ajax({
            type: 'PUT',
            contentType: 'application/json',
            url: buyerRatingURL(currentProduct),
            data:buyerRating,
            success: function (data, textStatus, jgXHR) {
                console.log("Buyer rating put:" + buyerRating);
            },
            error: function (jgXHR, textStatus, errorThrown) {
                console.log("setBuyerRating error: " + textStatus);
            }
        });

    }
    
    function buyerRatingURL(currentProduct) {

        var bidList = currentProduct['listOfBids'];
        bidList.sort(function (a, b) {
            return b.amount - a.amount;
        });
        var ratingURL = 'http://localhost:8091/api/users/setbuyerrating/' + bidList[0].bidder;
        console.log(ratingURL);
        return ratingURL;
    }
    
    function moveSoldProductToHistory(JSONHistory){
        console.log("in moveSoldProductToHistory");
        $.ajax({
            type: 'POST',
            contentType:'application/json',
            url: rootURL + '/history',
            data: JSONHistory,
            success: function (data, textStatus, jgXHR) {
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

    function getCategory(categoryInt) {
        var category;
        switch (categoryInt){
            case "1":
                category = "Torsk";
                break;
            case "2":
                category = "Makrill";
                break;
            case "3":
                category = "Kolja";
                break;
            case "4":
                category = "Lax";
                break;
            case "5":
                category = "Gråsej";
                break;
            case "6":
                category = "Sill";
                break;
            case "7":
                category = "Vitling";
                break;
            case "8":
                category = "Rödspotta";
                break;
            case "9":
                category = "Skaldjur";
                break;
            case "10":
                category = "Övrigt";
                break;
            default:
                category = "ERROR"
        }

        return category;
    }

    function populateUserProducts(listOfProducts) {
        document.getElementById('productList').innerHTML = "";
        $products = $('#productList');
        var productString="";
        var smallLimit = 90;
       for(i = 0; i < listOfProducts.length; i++){
           var startDate = new Date(listOfProducts[i].startDate);
           var endDate = new Date(listOfProducts[i].endDate)
           var isSold = listOfProducts[i].isSold;
           var productCategory = getCategory(listOfProducts[i].category);
           listOfBids = listOfProducts[i]['listOfBids'];

           productString+='<div class="OwnerProductObject"><div class="row"><div class="col-sm-4">';
           productString+='<img class="col-sm-12" src="' + listOfProducts[i].image + '">';
           productString+='</div><div class="col-sm-8">';
           productString+='<h3 id="ownerProductTitle">' + listOfProducts[i].title + '</h3>';
           productString+='<p class="ownerProductDescription">' + listOfProducts[i].description + '</p>';
           productString+='</div></div><div class="row"><div class="col-sm-6">';
           productString+='<p id="ownerProductStartDate">Datum tillagt: <br>' + startDate.toLocaleString() + '</p>';
           productString+='<p id="ownerProductEndDate">Slutdatum: <br>' + endDate.toLocaleString() + '</p>';
           productString+='<p id="ownerProductCategory">Kategori: <br>' + productCategory+ '</p>';
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
           if(isSold == "yes"){
               productString+='<p id="confirmPurchase" data-toggle="collapse" data-target="#buyerRatingDiv">Bekräfta köp</p>';
               productString+='<div id="buyerRatingDiv" class="collapse">';
               productString+='<fieldset class="rating">';
               productString+='<legend>Säljarbetyg:</legend>';
               productString+='<input type="radio" id="star5" name="rating" value="5" /><label for="star5">5 stars</label>';
               productString+='<input type="radio" id="star4" name="rating" value="4" /><label for="star4">4 stars</label>';
               productString+='<input type="radio" id="star3" name="rating" value="3" /><label for="star3">3 stars</label>';
               productString+='<input type="radio" id="star2" name="rating" value="2" /><label for="star2">2 stars</label>';
               productString+='<input type="radio" id="star1" name="rating" value="1" /><label for="star1">1 star</label>';
               productString+='</fieldset>';
               productString+='<div class="col-sm-4"><a id="lnkSetProductAsSold" href="#" data-value="'+ listOfProducts[i].id +'">Bekräfta köp</a></div></div>';
           }
           productString+='</div></div></div>';
       }
        $products.append(productString);
    }
});