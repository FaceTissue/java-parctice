<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/static/commons/meta.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>${title}</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/styles/login/login.css">
</head>
<body onload="init()">
<div class="img0"></div>
<img class="img2_1" src="${ctx}/static/images/login/2.png"/>
<img class="img2_2" src="${ctx}/static/images/login/2.png"/>
<img class="img2_3" src="${ctx}/static/images/login/2.png"/>
<img class="img2_4" src="${ctx}/static/images/login/2.png"/>
<img class="img2_5" src="${ctx}/static/images/login/2.png"/>
<form id="loginForm" action="${ctx}/login" method="post" onsubmit="return false;">
    <div class="login">
        <label>
            <p>用户名 <i>UserName</i></p>
            <input type="text" id="username" name="username" placeholder="请输入用户名" autocomplete="off">
        </label>
        <label>
            <p>密码 <i>Password</i></p>
            <input type="password" id="password" name="password" placeholder="请输入密码" autocomplete="off">
        </label>
        <button onclick="login()">登录</button>
        <br>
        <div class="tips"><span class="errTip">用户名或密码错误</span></div>
    </div>
</form>

<script type="text/javascript" src="${ctx}/static/other/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
    function init() {
        if (!isEmpty("${msg}")) {
            showInfo("${msg}");
        }
    }

    function login() {
        hideInfo();
        let username = $("#username").val();
        let password = $("#password").val();
        if (isEmpty(username)) {
            showInfo("请输入用户名！");
            return;
        }
        if (isEmpty(password)) {
            showInfo("请输入密码！");
            return;
        }
        document.forms[0].submit();
    }

    function showInfo(msg) {
        $(".errTip").html(msg);
        $(".tips").show();
    }

    function hideInfo() {
        $(".tips").hide();
    }

    function isEmpty(obj) {
        return typeof obj === undefined || obj == null || obj === "";
    }
</script>
</body>
</html>
