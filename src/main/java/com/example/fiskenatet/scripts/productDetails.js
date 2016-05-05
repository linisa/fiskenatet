$(document).ready(function () {

    var rootURL = 'http://localhost:8091/api';

    var currentUserId = sessionStorage.getItem('currentUser');
    var currentProductId = sessionStorage.getItem('currentProductId');
    var owner;
    var listOfBids;
    var currentProduct;

    getProductDetails();


    $(document).on("click", "#lnkProfile", function () {
        location.href="../webcontent/userProfile.html";
    });

    $(document).on("click", "#lnkLogOut", function () {
        sessionStorage.removeItem('currentUser');
        location.href="../webcontent/index.html";
    });

    $(document).on("click", "#buyNowPriceDetails", function () {
        alert("Swisha: " + currentProduct.buyNowPrice + " kr" + " till telefonnumret: " + owner.mobileNumber);
        setProductAsSold();
    });
    
    function setProductAsSold() {

        $.ajax({
            type: 'PUT',
            contentType: 'application/json',
            url: rootURL + '/products/issold/' + currentProductId,
            success: function (data, textStatus, jgXHR) {
                console.log("success");
                
            },
            error: function(jgXHR, textStatus, errorThrown) {
                console.log("editProduct error: " + textStatus);
            }
        });
    }
    
    
    function getHighestBid() {
        listOfBids = currentProduct['listOfBids'];
        if(listOfBids.length != 0){
           listOfBids.sort(function (a, b) {
                return b.amount - a.amount;
            });

            document.getElementById('highestBidDetails').innerHTML = "Högsta Bud: <br>" +  listOfBids[0].amount + " kr";
        }else{
            document.getElementById('highestBidDetails').innerHTML = "Högsta Bud: <br>" +  currentProduct.startPrice + " kr";
        }
    }

    $('#lnkAddBid').click(function () {
        console.log("klick!");
        var startPrice = currentProduct.startPrice;
        var newBid = document.getElementById('addBidDetails').value;
        console.log(newBid);
        try{
            var oldBid = listOfBids[0].amount;
        }catch(Exception){
            oldBid = startPrice
        }
        if(newBid > oldBid){
            addBid();
        }else{
            alert("För lågt bud");
        }

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
                location.reload();
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
                document.getElementById("addBidDetails").style.display = "none";
            }else{
                document.getElementById("lnkAddBid").style.display = "inline-block";
                document.getElementById("addBidDetails").style.display = "inline-block";
            }

            document.getElementById("lnkRegUser").style.display = "none";
        }else{
            document.getElementById("lnkAddProduct").style.display = "none";
            document.getElementById("lnkProfile").style.display = "none";
            document.getElementById("lnkLogOut").style.display = "none";
            document.getElementById("lnkAddBid").style.display = "none";
            document.getElementById("addBidDetails").style.display = "none";

            document.getElementById("lnkRegUser").style.display = "inline-block";
        }
    }
    
    function getProductDetails() {
        $.ajax({
            type: 'GET',
            contentType: 'application/json',
            url: rootURL + '/products/' + currentProductId,
            success: function (data, textStatus, jgXHR) {
                currentProduct = data;
                getProductOwner();
                getHighestBid();
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
        document.getElementById('categoryDetails').innerHTML = "Kategori: " + owner.category;
        document.getElementById('descriptionDetails').innerHTML = currentProduct.description;
        document.getElementById('endDateDetails').innerHTML = "Slutdatum: <br> " + currentProduct.endDate;
        document.getElementById('lnkAddBid').innerHTML = "Lägg ett bud";
        document.getElementById('startPriceDetails').innerHTML = "Utropspris: <br> " + currentProduct.startPrice + " kr";
        document.getElementById('buyNowPriceDetails').innerHTML = "Köp nu: <br> " + currentProduct.buyNowPrice + " kr";
    }
    
});