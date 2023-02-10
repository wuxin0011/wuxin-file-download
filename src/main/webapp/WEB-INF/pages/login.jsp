<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <jsp:include page="common/headFile.jsp"/>
    <style>
        .bg {
            width: 100vw;
            height: 100vh;
            background-size: cover;
            background: url(${pageContext.request.contextPath}/image/bg1.jpg) no-repeat center;
            z-index: -1;
            position: fixed;
        }

        .container {
            z-index: 10;
        }

    </style>
</head>
<body>
<div class="bg"></div>
<div class="container col-xl-10 col-xxl-8 px-4 py-5">
    <div class="row align-items-center g-lg-5 py-5">
        <div class="col-lg-7 text-center text-lg-start"></div>
        <div class="col-md-10 mx-auto col-lg-5">
            <div class="p-3 mt-5 p-md-5 border rounded-3 bg-light" id="loginForm">
                <div class="mb-3">
                    <input type="email" autocomplete="off" class="form-control" id="email" name="email"
                           placeholder="请输入邮箱...">
                </div>
                <div class=" mb-3">
                    <input type="password" autocomplete="off" class="form-control" id="password" name="password"
                           id="password"
                           placeholder="请输入密码...">
                </div>

                <div class="d-grid gap-2">
                    <button class="btn btn-primary fs-5" type="button" id="loginBtn">登录</button>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(function () {

        $("#loginBtn").click(function () {
            var email = $("#email").val();
            if (!email) {
                return alert('请输入邮箱');
            }

            var password = $("#password").val();
            if (password.length < 4 || password.length > 20) {
                return alert('密码4-20');
            }
            $.ajax({
                url: '/to/login',
                dataType: 'json',
                type: 'post',
                data: {'email': email, 'password': password},
                success: function (res) {

                    if (res.code === 200) {
                        setTimeout(() => {
                            window.location.href = '/'
                        }, 1000)
                    } else {
                        alert(res.message)
                    }
                },
                error: function () {
                    window.location.href = '/error'
                }

            })

        });
    })
</script>


</body>
</html>
