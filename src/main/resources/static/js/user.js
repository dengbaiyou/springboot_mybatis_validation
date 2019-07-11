var USER = {
    add: function () {
        d_ajax(
            "/user/add",
            {},
            function (html) {
                $("#right").html(html);
            });
    },
    save: function () {
        //判断验证是否成功，访问后台
        if($("#myForm").valid()){
            d_ajax(
                "/user/save",
                {username: $("#username").val(), password: $("#password").val()},
                function (result) {
                    var rel = JSON.parse(result);
                    layer.alert(rel.msg);
                });
        }
    },
    show:function () {
        d_ajax(
            "/user/list",
            {},
            function (html) {
                $("#right").html(html);
            }
        )
    }
}