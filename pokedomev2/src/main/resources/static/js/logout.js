//Logout link
$(document).ready (function () {
    $('.logout').on ('click', function () {
        document.forms["logoutForm"].submit();
    });
});