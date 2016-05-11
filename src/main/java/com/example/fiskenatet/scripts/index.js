
$(document).ready(function () {
    var rootURL = 'http://localhost:8091/api';
    var userUserName;
    var userPassword;
    var listOfBids;
    

    checkCategory();
    //getAllProducts();
    checkIfLoggedIn();
    
    function checkCategory() {
        document.getElementById("productList").innerHTML = "";
        var category = document.getElementById("selectCategory");
        var categoryChoice = category.options[category.selectedIndex].value;
        console.log(categoryChoice);
        if(categoryChoice == 0){
            getAllProducts();
        }else{
            getProductByCategory(categoryChoice);
        }
    }
    
    function checkIfLoggedIn() {
        if(sessionStorage.getItem('currentUser') != null){
            /*användare inloggad*/
            document.getElementById("lnkAddProduct").style.display = "inline-block";
            document.getElementById("lnkProfile").style.display = "inline-block";
            document.getElementById("lnkLogOut").style.display = "inline-block";
            

            document.getElementById("lnkLogIn").style.display = "none";
            document.getElementById("lnkRegUser").style.display = "none";
        }else{
            document.getElementById("lnkAddProduct").style.display = "none";
            document.getElementById("lnkProfile").style.display = "none";
            document.getElementById("lnkLogOut").style.display = "none";
            

            document.getElementById("lnkLogIn").style.display = "inline-block";
            document.getElementById("lnkRegUser").style.display = "inline-block";
        }
    }

    $('#selectCategory').change(function () {
        checkCategory();
    })


    $(document).on("click", "#lnkLogOut", function () {
        sessionStorage.removeItem('currentUser');
        location.reload();
    });

    $(document).on("click", "#lnkProfile", function () {
        location.href="../webcontent/userProfile.html";
    });


    function getProductByCategory(categoryChoice) {
        $.ajax({
            type: 'GET',
            contentType: 'application/json',
            url: rootURL + '/products/category/' + categoryChoice,
            success: function (data, textStatus, jgXHR) {
                populateProductList(data);
                console.log(data[0].title);

            },
            error: function (jgXHR, textStatus, errorThrown) {
                console.log("getAllProducts error: " + textStatus);
            }
        });
    }


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
            console.log("i productlistan");
            listOfBids = allProducts[i]['listOfBids'];

            var description = allProducts[i].description;

            listOfBids = allProducts[i]['listOfBids'];


            productString += '<div class="product"><a href="#" class="productLink" data-value="'+ allProducts[i].id +'"><div class = "col-sm-8">';
            productString += '<div><img src="' + allProducts[i].image + '" class="image"></div>';
            productString += '<div class="productText"><h3>' + allProducts[i].title + '</h3>';
            productString += '<p class="description">' + description.substr(0, smallLimit) + '...' + '</p></div></a></div>';
            productString += '<div class="col-sm-4"><p class="endDate">Slutdatum: <br>' + allProducts[i].endDate + '</p>';

            if(listOfBids.length != 0){
                listOfBids.sort(function (a, b) {
                    return b.amount - a.amount;
                });

                productString += '<p class="highestBid">Högsta Bud:<br>' +  listOfBids[0].amount + " kr"  + '</p>';
            }else{
                productString += '<p class="highestBid">Högsta Bud:<br>' +  allProducts[i].startPrice + " kr" + '</p>';
            }


            productString += '<p class="buyNowPrice">Köp Nu:<br>' + allProducts[i].buyNowPrice + '</p></div></div>';
        }
        $products.append(productString);
    }
    
    $(document).on("click", ".productLink", function () {
        console.log("click");
        var currentProductId = $(this).data("value");
        sessionStorage.setItem('currentProductId', currentProductId);
        console.log(currentProductId);
        location.href = '../webcontent/productDetails.html';
    })

    $('#btnLogIn').click(function () {
        console.log("KLICK LOGIN!");
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

