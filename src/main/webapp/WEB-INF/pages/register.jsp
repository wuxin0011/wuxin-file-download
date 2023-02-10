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
            <div class="p-4 p-md-5 border rounded-3 bg-light" ">
                <div class=" mb-2">
                    <input type="email" class="form-control" name="email" id="email" placeholder="xx@xxx.com" required>
                </div>
                <div class=" mb-2">
                    <input type="password" class="form-control" id="password" name="password" placeholder="密码"
                           required>
                </div>
                <div class=" mb-2">
                    <input type="password" class="form-control" id="repassword" name="repassword" placeholder="密码验证"
                           required>
                </div>
                <div class="d-grid gap-2">
                    <button class="btn btn-primary fs-5" type="button" id="registerBtn">注册</button>
                </div>
            </div>
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
                return alert('请输入邮箱');
            }

            var password = $("#password").val().trim();
            if (4 > password.length && password.length > 20) {
                return alert('密码4-20')
            }

            var repassword = $("#repassword").val().trim();
            if (4 > repassword.length && repassword.length > 20) {
                return alert('密码4-20')
            }

            if (repassword !== password) {
                return alert('两次密码不一致')
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
