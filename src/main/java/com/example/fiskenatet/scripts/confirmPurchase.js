CheckIfLoggedIn();

function CheckIfLoggedIn() {
    currentUserID = sessionStorage.getItem("currentUser");
    if(currentUserID == null){
        location.href="../webcontent/index.html";
    }
}

$(document).ready(function () {
    var rootURL = 'http://localhost:8091/api';
    var currentProductId = sessionStorage.getItem('currentProductId');
    var currentUserID;
    var currentProduct;
    var owner;


    
    
    getProductDetails();

    $(document).on("click", "#btnSwishOption", function () {
        //TODO: funktionalitet för vinst på bud istället för buyout
        document.getElementById('confirmSwishAmount').innerHTML = currentProduct.buyNowPrice;
        document.getElementById('confirmSwishPhone').innerHTML = owner.mobileNumber;
    });

    $(document).on("click", "#btnConfirmSwish", function () {
        document.getElementById('btnConfirmSwish')
        setSellerRating();
        addBidIfBuyout(function () {
            setProductAsSold();
        });
    });
    
    function addBidIfBuyout(callback) {
        console.log("in addUser");
        $.ajax({
            type: 'POST',
            contentType:'application/json',
            url: rootURL + '/bids',
            data: buyoutBidFormToJSON(),
            success: function (data, textStatus, jgXHR) {
                console.log("GREAT SUCCESS!");

                callback();
            },
            error: function (jgXHR, textStatus, errorThrown) {
                console.log("send Error " +textStatus + "  " + errorThrown);
            },
        })
    }

    function buyoutBidFormToJSON() {
        console.log("i form to json");
        var bidDate = new Date();
        var bid = JSON.stringify({
            "currentProduct": {'id' : currentProductId},
            "bidder": {'id' : currentUserID},
            "amount": currentProduct.buyNowPrice,
            "bidDate": bidDate

        });
        console.log(bid);
        return bid;
    }
    
    function setSellerRating() {
        var sellerRating = $("input[type='radio'][name='rating']:checked").val();
        console.log("setSellerRating " + sellerRating);
        $.ajax({
            type: 'PUT',
            contentType: 'application/json',
            url: rootURL + '/users/setsellerrating/' + currentProduct.owner,
            data:sellerRating,
            success: function (data, textStatus, jgXHR) {
                console.log("Seller rating put:" + sellerRating);
            },
            error: function (jgXHR, textStatus, errorThrown) {
                console.log("setSellerRating error: " + textStatus);
            }
        });
        
    }
    
    

    function getProductDetails() {
        $.ajax({
            type: 'GET',
            contentType: 'application/json',
            url: rootURL + '/products/' + currentProductId,
            success: function (data, textStatus, jgXHR) {
                currentProduct = data;
                getProductOwner();
            },
            error: function (jgXHR, textStatus, errorThrown) {
                console.log("getProductDetails error: " + textStatus);
            }
        });
    }

    function getProductOwner() {
        $.ajax({
            type: 'GET',
            contentType: 'application/json',
            url: rootURL + '/users/' + currentProduct.owner,
            success: function (data, textStatus, jgXHR) {
                owner = data;
            },
            error: function (jgXHR, textStatus, errorThrown) {
                console.log("getAllProducts error: " + textStatus);
            }
        });
    }



    function setProductAsSold() {
        console.log("Setting product as sold")
        $.ajax({
            type: 'PUT',
            contentType: 'application/json',
            url: rootURL + '/products/issold/' + currentProductId,
            success: function (data, textStatus, jgXHR) {
                console.log("success");
            },
            error: function(jgXHR, textStatus, errorThrown) {
                console.log("setProductAsSold error: " + textStatus);
            }
        });
    }
});