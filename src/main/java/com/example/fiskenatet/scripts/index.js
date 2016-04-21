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
        
        productString+='<div><a href="#"><div class = "col-sm-8">';
        productString+='<div><img src="'+ allProducts[i].image + '"></div>';
        productString+='<div><h3>' + allProducts[i].title + '</h3>';
        productString+='<p>' + allProducts[i].shortDescription + '</p></div></a></div>';
        productString+='<div class="col-sm-4"><p>'+ allProducts[i].endDate +'</p>';
        productString+='<p>'+ allProducts[i].highestBid +'</p>';
        productString+='<p>'+ allProducts[i].buyNowPrice+'</p></div></div>';
        
    }
    
    $products.append(productString);

}