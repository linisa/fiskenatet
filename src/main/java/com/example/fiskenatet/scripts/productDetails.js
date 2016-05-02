$(document).ready(function () {

    var rootURL = 'http://localhost:8091/api';

    var currentUserId = sessionStorage.getItem('currentUser');
    var currentProductId = sessionStorage.getItem('currentProductId');
    var owner;
    getProductDetails();

    var currentProduct;


    $('#lnkAddBid').click(function () {
        console.log("klick!");

        addBid();


    });
    
    function addBid(){
        console.log("in addBid");
        $.ajax({
            type: 'POST',
            contentType:'application/json',
            url: rootURL + '/bids',
            data: formToJSON(),
            success: function (data, textStatus, jgXHR) {
                console.log("GREAT SUCCESS!");
                
            },
            error: function (jgXHR, textStatus, errorThrown) {
                console.log("send Error " +textStatus + "  " + errorThrown);
            }
        })
    }

    function formToJSON() {
        console.log("i form to json");

        var date = new Date();
        var product = JSON.stringify({


            "currentProduct": {'id' : currentProductId},
            "bidder": {'id' : currentUserId},
            "amount": $('#addBidDetails').val(),
            "bidDate": date

        });

        return product;
    }



    function checkIfLoggedIn() {
        if(sessionStorage.getItem('currentUser') != null){
            /*användare inloggad*/
            document.getElementById("lnkAddProduct").style.display = "inline-block";
            document.getElementById("lnkProfile").style.display = "inline-block";
            document.getElementById("lnkLogOut").style.display = "inline-block";

            if(sessionStorage.getItem('currentUser') == owner.id){
                document.getElementById("lnkAddBid").style.display = "none";
            }else{
                document.getElementById("lnkAddBid").style.display = "inline-block";
            }

            document.getElementById("lnkRegUser").style.display = "none";
        }else{
            document.getElementById("lnkAddProduct").style.display = "none";
            document.getElementById("lnkProfile").style.display = "none";
            document.getElementById("lnkLogOut").style.display = "none";
            document.getElementById("lnkAddBid").style.display = "none";

            document.getElementById("lnkRegUser").style.display = "inline-block";
        }
    }

    $(document).on("click", "#lnkProfile", function () {
        location.href="../webcontent/userProfile.html";
    });
    
    $(document).on("click", "#lnkLogOut", function () {
        sessionStorage.removeItem('currentUser');
        location.href="../webcontent/index.html";
    });
    
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
                console.log("getAllProducts error: " + textStatus);
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
                populateProductDetails();
                checkIfLoggedIn();
            },
            error: function (jgXHR, textStatus, errorThrown) {
                console.log("getAllProducts error: " + textStatus);
            }
        });
    }

    function populateProductDetails() {
        var startDate= new Date(currentProduct.startDate).toLocaleString();
        
        document.getElementById('productImage').src = currentProduct.image;
        document.getElementById('productTextDetails').innerHTML  = currentProduct.title;
        document.getElementById('ownerDetails').innerHTML = "Säljs av: " + owner.userName;
        document.getElementById('startDateDetails').innerHTML = " " + startDate;
        document.getElementById('descriptionDetails').innerHTML = currentProduct.description;
        document.getElementById('endDateDetails').innerHTML = "Slutdatum: <br> " + currentProduct.endDate;
        document.getElementById('lnkAddBid').innerHTML = "Lägg ett bud";
        document.getElementById('startPriceDetails').innerHTML = "Utropspris: <br> " + currentProduct.startPrice;
        document.getElementById('highestBidDetails').innerHTML = "Högsta Bud: <br> " + currentProduct.highestBid;
        document.getElementById('buyNowPriceDetails').innerHTML = "Köp nu: <br> " + currentProduct.buyNowPrice;
    }
    
});