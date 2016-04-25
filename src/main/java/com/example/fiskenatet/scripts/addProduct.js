/**
 * Created by Erik on 2016-04-25.
 */
$(document).ready(function () {
    var rootURL ='http://localhost:8091/api';
    
    
    $('#btnAddProduct').click(function () {
        console.log("klick!");
        addProduct();
    });
    
    function addProduct(){
        console.log("in addProd");
        $.ajax({
            type: 'POST',
            contentType:'application/json',
            url: rootURL + '/products',
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
        var startDate = new Date();
        var product = JSON.stringify({
            "title": $('#txtProductTitle').val(),
            "image": $('#txtProductImage').val(),
            "shortDescription": $('#txtShortDes').val(),
            "longDescription": $('#txtLongDes').val(),
            "startPrice": $('#txtStartPrice').val(),
            "buyNowPrice": $('#txtBuyNow').val()
            /*"startDate": startDate*/
        });
        console.log(product);
        return product;
    }
});

