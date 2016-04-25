/**
 * Created by Erik on 2016-04-21.
 */

var rootURL = 'http://localhost:8091/api';

getAllProducts();

function getAllProducts() {
    $.ajax({
        type: 'GET',
        contentType: 'application/json',
        url: rootURL + '/products',
        success: function (data, textStatus, jgXHR) {
            populateProductList(data)
        },
        error: function(jgXHR, textStatus, errorThrown) {
            console.log("getAllProducts error: " + textStatus);
        }
    });
}

function populateProductList(allProducts){
    $products = $('#productList');
    var productString;
    for(i = 0; i < allProducts.length; i++){
        
        productString+='<div class="product"><a href="#"><div class = "col-sm-8">';
        productString+='<div><img src="'+ allProducts[i].image + '" class="image"></div>';
        productString+='<div class="title"><h3>' + allProducts[i].title + '</h3>';
        productString+='<p class="shortDescription">' + allProducts[i].shortDescription + '</p></div></a></div>';
        productString+='<div class="col-sm-4"><p class="endDate">'+ allProducts[i].endDate +'</p>';
        productString+='<p class="highestBid">'+ allProducts[i].highestBid +'</p>';
        productString+='<p class="buyNowPrice">'+ allProducts[i].buyNowPrice+'</p></div></div>';
        
    }
    
    $products.append(productString);

}