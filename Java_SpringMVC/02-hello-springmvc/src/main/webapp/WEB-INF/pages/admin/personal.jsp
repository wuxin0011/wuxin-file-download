<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

        <form action="" method="post" class="col-lg-8 col-sm-8 col-xs-12 col-xxl-12 px-10 py-10 mt-5 form"
              style="
				margin: auto;">
            <div class="mb-3 row">
                <label for="username" class="col-sm-3 col-form-label">用户名</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="username" name="username" required>
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
                    <input type="email" name="email" class="form-control" id="email" required>
                </div>
            </div>
            <div class="mb-3 row">
                <label for="role" class="col-sm-3 col-form-label">角色信息</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control" id="role" value="管理员" readonly>
                </div>
            </div>
            <div class="mb-3 row">
                <button type="submit" class="btn btn-primary btn-sm col-sm-12">提交</button>
            </div>
        </form>

    </main>


</body>
</html>
