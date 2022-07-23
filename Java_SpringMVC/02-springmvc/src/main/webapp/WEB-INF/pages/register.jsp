<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>注册</title>
    <jsp:include page="common/headFile.jsp"/>
    <style>
        .bg {
            width: 100vw;
            height: 100vh;
            background: url(${pageContext.request.contextPath}/image/bg1.jpg);
            background-position: center;
            background-size: cover;
            background-repeat: no-repeat;
            z-index: -1;
            position: fixed;
        }

        .container {
            z-index: 10;
        }

        p.text-danger {
            font-size: 14px !important;
        }

        /*p#errorPassword,*/
        /*p#errorRePassword,*/
        /*p#errorEmail {*/
        /*    display: none;*/
        /*}*/
    </style>
</head>
<body>
<div class="bg"></div>
<div class="container col-xl-10 col-xxl-8 px-4 py-5">
    <div class="row align-items-center g-lg-5 py-5">
        <div class="col-lg-7 text-center text-lg-start">
        </div>
        <div class="col-md-10 mx-auto col-lg-5">
            <form class="p-4 p-md-5 border rounded-3 bg-light" method="post">
                <div class=" mb-2">
                    <input type="email" class="form-control" name="email" id="email" placeholder="xx@xxx.com" required>
                    <p class="text-danger " id="errorMessage"></p>
                </div>
                <div class=" mb-2">
                    <input type="password" class="form-control" id="password" name="password" placeholder="密码"
                           required>
                    <p class="text-danger" id="errorPassword"></p>
                </div>
                <div class=" mb-2">
                    <input type="password" class="form-control" id="repassword" name="repassword" placeholder="密码验证"
                           required>
                    <p class="text-danger" id="errorRePassword"></p>
                </div>
                <div class="d-grid gap-2">
                    <button class="btn btn-primary fs-5" type="button" id="registerBtn">注册</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    $(function () {

        $("#registerBtn").click(function (e) {
            e.stopPropagation()
            var regxEmail = '^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$'
            var email = $("#email").val().trim();

            if (!email) {
                $("#errorMessage").text("请输入邮箱").show().hide(2000);
                return;
            }

            var password = $("#password").val().trim();
            if (4 > password.length && password.length > 20) {
                $("#errorPassword").text("密码4-20").show().hide(2000);
                return;
            }

            var repassword = $("#repassword").val().trim();
            if (4 > repassword.length && repassword.length > 20) {
                $("#errorRePassword").text("密码4-20").show().hide(2000);
                return;
            }

            if (repassword != password) {
                $("#errorRePassword").text("两次密码不一致！").show().hide(2000);
                return;
            }

            $.ajax({
                url: '/user/register',
                dataType:'json',
                type: 'post',
                data: {'email': email, 'password': password, 'repassword': repassword},
                success: function (res) {
                    if (res.code === 200) {
                        alert("注册成功！")
                        setTimeout(() => {
                            window.location.href = '/login'
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
