$(function(){
    $('#submitRegister').on('click', function() {
        var data={};
        data.userName = $("#userName").val();
        data.password = $("#password").val();
        data.email = $("#email").val();
        data.phone = $("#phone").val();
        $.ajax({
            url: 'user/register.html',
            type: "post",
            data: data,
            async: false,
            success: function (result) {
                alert(result);
            }
        });
    });

    $('#submitLogin').on('click', function() {
        var data={};
        data.userName = $("#userName").val();
        data.password = $("#password").val();
        $.ajax({
            url: 'user/login.html',
            type: "post",
            data: data,
            async: false,
            success: function (result) {
                alert(result);
            }
        });
    });
}) ;
