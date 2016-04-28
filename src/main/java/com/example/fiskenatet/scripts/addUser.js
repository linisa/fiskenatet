$(document).ready(function () {
    var rootURL ='http://localhost:8091/api';


    $('#btnAddUser').click(function () {
        console.log("klick!");
        addUser();
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
            },
            error: function (jgXHR, textStatus, errorThrown) {
                console.log("send Error " +textStatus + "  " + errorThrown);
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
});