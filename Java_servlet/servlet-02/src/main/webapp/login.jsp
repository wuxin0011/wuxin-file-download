<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        html, body {
            width: 100%;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        input {
            width: 300px;
            padding: 10px;
            height: 24px;
            font-size: 25px;
        }
    </style>
</head>
<body>

<form action="${pageContext.request.contextPath}/login">
    用户名:
    <input type="text" name="username" id="username" placeholder="请输入用户名...">
    <br>
    密码:
    <input type="text" name="password" id="password" placeholder="请输入密码...">
    <input type="submit" value="登录">

</form>

</body>
</html>