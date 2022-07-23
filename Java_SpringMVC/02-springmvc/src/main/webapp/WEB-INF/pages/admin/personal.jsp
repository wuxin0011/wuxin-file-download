<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>个人中心</title>
    <jsp:include page="../common/headFile.jsp"/>

</head>
<body>
<div class="container col-xl-6 col-sm-12 col-xs-12 col-xxl-4 px-10 py-10 mt-5">
    <jsp:include page="../common/admin/header.jsp"/>
    <main>
        <div class="col-lg-8 col-sm-8 col-xs-12 col-xxl-12 px-10 py-10 mt-5 form" style=" margin: auto;">
            <div class="mb-3 row">
                <label for="username" class="col-sm-3 col-form-label">用户名</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="username" value="${sessionScope.loginUser.username}"
                           name="username" required>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="password" class="col-sm-3 col-form-label">密码</label>
                <div class="col-sm-9">
                    <input type="password" id="password" name="password" class="form-control">
                </div>
            </div>
            <div class="mb-3 row">
                <label for="verifyPassword" class="col-sm-3 col-form-label">验证密码</label>
                <div class="col-sm-9">
                    <input type="password" class="form-control" id="verifyPassword" name="verifyPassword">
                </div>
            </div>
            <div class="mb-3 row">
                <label for="email" class="col-sm-3 col-form-label">邮箱</label>
                <div class="col-sm-9">
                    <input type="email" name="email" class="form-control" id="email"
                           value="${sessionScope.loginUser.email}" required>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="role" class="col-sm-3 col-form-label">角色信息</label>
                <div class="col-sm-9">
                    <c:if test="${sessionScope.loginUser.role==1}">
                        <input type="text" class="form-control" id="role" value="管理员" readonly>
                    </c:if>
                    <c:if test="${sessionScope.loginUser.role==0}">
                        <input type="text" class="form-control" id="role" value="用户" readonly>
                    </c:if>

                </div>
            </div>
            <div class="mb-3 row">
                <label for="role" class="col-sm-3 col-form-label"></label>
                <div class="col-sm-9">
                    <button type="submit" class="btn btn-primary btn-sm col-sm-12 " id="submitBtn">提交</button>
                </div>
            </div>
        </div>

    </main>

    <script>
        $(function () {

            $("#submitBtn").click(function (e) {
                e.stopPropagation()
                var username = $("#username").val();
                if (username.length < 2 || username.length > 15) {
                    alert('用户名长度2-15!')
                    return;
                }

                var email = $("#email").val();
                if (!email) {
                    alert('请输入邮箱!')
                    return;
                }

                var password = $("#password").val();
                var repassword = $("#repassword").val();

                if (password && repassword) {


                    if (password.length !== 0 || (password.length < 4 || password.length > 20)) {
                        alert('密码长度4-20!')
                        return;
                    }

                    if (!(repassword.length === password.length && epassword === password)) {
                        alert('两次密码不相等！')
                        return;
                    }

                }


                if (!confirm('确认修改?')) {
                    return;
                }


                $.ajax({
                    url: '/admin/user/person/change',
                    type: 'post',
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify({
                        id:${sessionScope.loginUser.id},
                        'email': email,
                        'password': password,
                        'repassword': repassword,
                        'username': username
                    }),
                    success: function (res) {
                        // 自动执行退出 防止用户刷新不退出！
                        if (res.code === 200) {
                            logout()
                        } else {
                            alert(res.message)
                        }
                    },
                    error: function () {
                        alert('修改失败！')
                    }

                })

                return false;
            });
        })


        function logout() {
            $.ajax({
                    url: '/admin/user/logout',
                    type: 'get',
                    dataType: 'json',
                    success: function (result) {
                        if (result === 200) {
                            alert('修改成功！即将退出，请重新登录!')
                            setTimeout(() => {
                                window.location.href = '/login'
                            }, 1000)
                        }
                    }
                }
            )

        }
    </script>


</body>
</html>
