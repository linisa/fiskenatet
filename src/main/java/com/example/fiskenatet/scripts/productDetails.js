$(document).ready(function () {

    var rootURL = 'http://localhost:8091/api';

    var currentProductId = sessionStorage.getItem('currentProductId');
    var owner;
    getProductDetails();

    var currentProduct;

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
            },
            error: function (jgXHR, textStatus, errorThrown) {
                console.log("getAllProducts error: " + textStatus);
            }
        });
    }

    function populateProductDetails() {
        $product = $('#productDetails');
        var startDate= new Date(currentProduct.startDate).toLocaleString();
        var productString="";

            productString += '<div class="product"><div>';
            productString += '<div class="row"><div class="col-sm-6 col-sm-offset-3"><img class="col-sm-12" src="' + currentProduct.image + '"></div></div>';
            productString += '<div class="col-sm-8"><p class="productTextDetails">' + currentProduct.title + '</p>';
            productString += '<p class="ownerDetails">Säljs av: ' + owner.firstName + " " + owner.lastName + " " + startDate +'</p>';
            productString += '<p class="descriptionDetails">' + currentProduct.description + '</p></div></div>';
            productString += '<div class="col-sm-4"><p class="endDateDetails">Slutdatum:<br>' + currentProduct.endDate + '</p>';
            productString += '<p class="startPriceDetails">Startpris<br>' + currentProduct.startPrice + '</p>';
            productString += '<p class="highestBidDetails">Högsta Bud<br>' + currentProduct.highestBid + '</p>';
            productString += '<p class="buyNowPriceDetails">Köp Nu:<br>' + currentProduct.buyNowPrice + '</p></div></div>';


        $product.append(productString);
    }


});