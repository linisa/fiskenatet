$(document).ready(function () {
    var rootURL = 'http://localhost:8091/api';
    var currentUserID = sessionStorage.getItem("currentUser");
    var currentUser;

    getUserById();
    
    $(document).on("click", "#lnkLogOut", function () {
        sessionStorage.removeItem('currentUser');
        location.href="../webcontent/index.html";
    });

    $(document).on("click", "#btnDeleteUser", function () {
        deleteUser()
    });
    
    function deleteUser() {
        $.ajax({
            type: 'DELETE',
            contentType: 'application/json',
            url: rootURL + '/users/' + currentUserID,
            success: function (data, textStatus, jgXHR) {
                sessionStorage.removeItem('currentUser');
                location.href="../webcontent/index.html";
            }
        });
    }

    function getUserById() {
        $.ajax({
            type: 'GET',
            contentType: 'application/json',
            url: rootURL + '/users/' + currentUserID,
            success: function (data, textStatus, jgXHR) {
                currentUser = data;
                console.log(data);
                populateUserInfo();
            }
        });
    }

    function populateUserInfo() {
        document.getElementById('upUserName').innerHTML =currentUser.userName;
        document.getElementById('upFirstName').innerHTML =currentUser.firstName;
        document.getElementById('upLastName').innerHTML =currentUser.lastName;
        document.getElementById('upEmail').innerHTML =currentUser.email;
        document.getElementById('upMobileNumber').innerHTML =currentUser.mobileNumber;
        //document.getElementById('upRatingAsSeller').innerHTML =currentUser[''];
        //document.getElementById('upRatingAsBuyer').innerHTML =currentUser[''];
    }
    
    

});
