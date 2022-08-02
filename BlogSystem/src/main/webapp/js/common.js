// 退出登录执行逻辑
let logout = document.querySelector("#logout");
logout.onclick = function logout() {
    $.ajax({
        type: "get",
        url: "logout",
        contentType: "application/json; charset=utf8",
        success: function(body) {
            let type = typeof(body);
            if (type === "string") {
                alert("未知错误!");
                return;
            }

            if (body.ok) {
                //注销成功，重定向登录页面
                alert(body.reason);
                location.assign("blog_login.html");
            } else {
                alert("提示:" + body.reason);
            }
        }
    });
}
