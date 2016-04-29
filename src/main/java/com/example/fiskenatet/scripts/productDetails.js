$(document).ready(function () {

    var rootURL = 'http://localhost:8091/api';

    var currentProductId = sessionStorage.getItem('currentProductId');

    getProductDetails(currentProductId);

    var currentProduct;
    function getProductDetails() {
        $.ajax({
            type: 'GET',
            contentType: 'application/json',
            url: rootURL + '/products' + currentProductId,
            success: function (data, textStatus, jgXHR) {
                currentProduct = data;
                populateProductDetails();
            },
            error: function (jgXHR, textStatus, errorThrown) {
                console.log("getAllProducts error: " + textStatus);
            }
        });
    }

    function populateProductDetails() {
        $product = $('#productDetails');
        var productString;

            productString += '<div class="products"><a href="#"><div class = "col-sm-8">';
            productString += '<div><img src="' + currentProduct.image + '" class="image"></div>';
            productString += '<div class="productText"><h3>' + currentProduct.title + '</h3>';
            productString += '<p class="description">' + currentProduct.description + '</p></div></a></div>';
            productString += '<div class="col-sm-4"><p class="endDate">End Date: <br>' + currentProduct.endDate + '</p>';
            productString += '<p class="highestBid">Highest Bid:<br>' + currentProduct.highestBid + '</p>';
            productString += '<p class="buyNowPrice">Buy Now:<br>' + currentProduct.buyNowPrice + '</p></div></div>';

        $product.append(productString);
    }


});