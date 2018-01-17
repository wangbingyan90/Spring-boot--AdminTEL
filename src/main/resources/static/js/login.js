

$("input").keydown(function(e){
    if (e.keyCode==13) {
        $("form").submit();
    }
});



function loginSubmit(){
    var username = $("#username").val();
    var password = $("#password").val();
    var user = {name:username,passow:password};//拼装成json格式
    var tip = $('#iforget');
    var b = $('#login-form-submit');
    if (username.length > 0 || password.length > 0) {
        $.ajax({
            type: "POST",
            url: '/login/auth',
            // 'password': $.md5("u.val() + p.val())
            data: user,
            dataType: 'json',
            beforeSend: function () {
                b.attr('disabled',true);
                b.val('正在登录,请稍后');
            },
            success: function (data) {///去更新cookies
                if (data!=null) {
                    tip.html('登陆成功')
                    window.location.href = "/admin";
                }else{
                    tip.html('账号或者密码错误')
                }
            },
            error: function () {
                    tip.html('账号或者密码错误');
            },
            complete:function(){
                b.removeAttr('disabled');
                b.val('登录');
            }

        });
    } else {
        tip.html('用户名或密码不能为空')
    }
}
///忘记密码
$("#iforget").click(function () {
    $("#login_model").hide();
    $("#forget_model").show();

});

///取回密码
$("#Retrievenow").click(function () {
    var usrmail = $("#usrmail").val();
    if (!Test_email(usrmail)) {
        // alert(msgggg.pssjs1);
        return false;
    }
    $.ajax({
        type: "POST",
        url: '/users/AjaxServer/checkis.ashx',
        data: {typex: 5, usrmail: usrmail},
        success: function (data) {//

            alert(data);
            $("#login_model").show();
            $("#forget_model").hide();
            $("#usrmail").val("");
            $("#username").val("");
            $("#userpwd").val("");

        }
    });


});
//返回
$("#denglou").click(function () {
    $("#usrmail").val("");
    $("#username").val("");
    $("#userpwd").val("");
    $("#login_model").show();
    $("#forget_model").hide();

});
