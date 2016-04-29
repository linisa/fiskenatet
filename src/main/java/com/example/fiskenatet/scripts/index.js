
$(document).ready(function () {

    var userUserName;
    var userPassword;
    
    var rootURL = 'http://localhost:8091/api';

    getAllProducts();
    checkIfLoggedIn();

    function checkIfLoggedIn() {
        if(sessionStorage.getItem('currentUser') != null){
            /*användare inloggad*/
            document.getElementById("lnkLogOut").style.display = "inline-block";
            document.getElementById("lnkAddProduct").style.display = "inline-block";
            document.getElementById("LogIn").style.display = "none";
        }else{
            document.getElementById("lnkLogOut").style.display = "none";
            document.getElementById("lnkAddProduct").style.display = "none";
            document.getElementById("LogIn").style.display = "inline-block";
        }
    }

    $(document).on("click", "#lnkLogOut", function () {
        sessionStorage.removeItem('currentUser');
        location.reload();
    });



    function getAllProducts() {
        $.ajax({
            type: 'GET',
            contentType: 'application/json',
            url: rootURL + '/products',
            success: function (data, textStatus, jgXHR) {
                populateProductList(data);
                console.log(data[0].title);
            },
            error: function (jgXHR, textStatus, errorThrown) {
                console.log("getAllProducts error: " + textStatus);
            }
        });
    }

    function populateProductList(allProducts) {
        $products = $('#productList');
        var productString="";
        var smallLimit = 90;
        for (i = 0; i < allProducts.length; i++) {
            var description = allProducts[i].description;
            productString += '<div class="product"><a href="#" class="productLink" data-value="'+ allProducts[i].id +'"><div class = "col-sm-8">';
            productString += '<div><img src="' + allProducts[i].image + '" class="image"></div>';
            productString += '<div class="productText"><h3>' + allProducts[i].title + '</h3>';
            productString += '<p class="description">' + description.substr(0, smallLimit) + '...' + '</p></div></a></div>';
            productString += '<div class="col-sm-4"><p class="endDate">End Date: <br>' + allProducts[i].endDate + '</p>';
            productString += '<p class="highestBid">Highest Bid:<br>' + allProducts[i].highestBid + '</p>';
            productString += '<p class="buyNowPrice">Buy Now:<br>' + allProducts[i].buyNowPrice + '</p></div></div>';
        }
        $products.append(productString);
    }
    
    $(document).on("click", ".productLink", function () {
        var currentProductId = $(this).data("value");
        sessionStorage.setItem('currentProductId', currentProductId);
        location.href = '../webcontent/productDetails.html';
    })

    $('#btnLogIn').click(function () {
        console.log("KLICK LOGIN!")
        userUserName = $('#UserUserName').val();
        userPassword = $('#UserPassword').val();
        console.log(userUserName);
        getUserByUserName();
    });

    function getUserByUserName() {
        $.ajax({
            type: 'GET',
            contentType: 'application/json',
            url: rootURL + '/username/' + userUserName ,
            success: function (data, textStatus, jgXHR) {
                console.log("i sucess" + data.password);
                    logInValidation(data);
            },
            error: function (jgXHR, textStatus, errorThrown) {
            }
        });
    }
    
    function logInValidation(foundUser) {
        console.log("i validation");
        if(foundUser.password == userPassword){
            console.log("Log in success" + foundUser.firstName);
            sessionStorage.setItem('currentUser', foundUser.id);
            location.reload();
        }else{
            alert("Fel lösenord!");
            //MAKE ALERT FEL PASS
        }
    }





});

