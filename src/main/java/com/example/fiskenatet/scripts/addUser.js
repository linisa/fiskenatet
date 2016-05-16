$(document).ready(function () {
    var rootURL ='http://localhost:8091/api';


    $('#btnAddUser').click(function () {
        console.log("klick!");
        var password = document.getElementById("tfPassword").value;
        var repeatPassword = document.getElementById("tfPasswordRepeat").value;
        if(password == repeatPassword){
            addUser();
        }else{
            alert("Lösenorden stämmer ej överrens");
        }
    });

    function addUser(){
        console.log("in addUser");
        $.ajax({
            type: 'POST',
            contentType:'application/json',
            url: rootURL + '/users',
            data: formToJSON(),
            success: function (data, textStatus, jgXHR) {
                console.log("GREAT SUCCESS!");
                moveMe();
            },
            error: function (jgXHR, textStatus, errorThrown) {
                console.log("send Error " +textStatus + "  " + errorThrown);
            },
            complete: function (jgXHR, textStatus, errorThrown) {
                console.log("GREAT COMPLETE!");
                moveMe();
            }
        })
    }
    function formToJSON() {
        console.log("i form to json");
        var product = JSON.stringify({
            "firstName": $('#tfFirstName').val(),
            "lastName": $('#tfLastName').val(),
            "userName": $('#tfUserName').val(),
            "password": $('#tfPassword').val(),
            "email": $('#tfEmail').val(),
            "mobileNumber": $('#tfMobileNumber').val()
            /*"startDate": startDate*/
        });
        console.log(product);
        return product;
    }

    function moveMe() {
        console.log("i move me");
        location.href = "../webcontent/index.html"

    }
});