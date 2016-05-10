$(document).ready(function() {
    var rootURL = 'http://localhost:8091/api';

    var currentProductID = sessionStorage.getItem('productToEdit');
    var currentProduct;

    getProduct();

    $('#btnUpdateProduct').click(function () {
        console.log("button clicked");
        updateProduct();
        return false;
    });

    function getProduct() {
        $.ajax({
            type: 'GET',
            contentType: 'application/json',
            url: rootURL + '/products/' + currentProductID,
            success: function (data, textStatus, jgXHR) {
                currentProduct = data;
                updateForm();
            },
            error: function(jgXHR, textStatus, errorThrown) {
                //alert('getCustomer error: ' + textStatus);
                console.log("getCustomer error: " + textStatus);
            }
        });
    }

    function updateForm() {
        document.getElementById("tfProductTitle").value = currentProduct['title'];
        document.getElementById("tfProductImage").value = currentProduct['image'];
        document.getElementById("tfDescription").value = currentProduct['description'];
        document.getElementById("tfStartPrice").value = currentProduct['startPrice'];
        document.getElementById("tfBuyNow").value = currentProduct['buyNowPrice'];
    }

    function updateProduct() {
        $.ajax({
            type: 'PUT',
            contentType: 'application/json',
            url: rootURL + '/products/' + currentProductID,
            data: formToJSON(),
            success: function (data, textStatus, jgXHR) {
                console.log("success");
                sessionStorage.removeItem("productToEdit");
                location.href="../webcontent/userProfile.html";
            },
            error: function(jgXHR, textStatus, errorThrown) {
                console.log("editProduct error: " + textStatus);
            }
        });
    }

    function formToJSON() {
        var product = JSON.stringify({
            
            "category" : $( "#selectCategory option:selected" ).val(),
            "title": $('#tfProductTitle').val(),
            "image": $('#tfProductImage').val(),
            "description": $('#tfDescription').val(),
            "startPrice": $('#tfStartPrice').val(),
            "buyNowPrice": $('#tfBuyNow').val(),

        });
        console.log(product);
        return product;
    }
});
