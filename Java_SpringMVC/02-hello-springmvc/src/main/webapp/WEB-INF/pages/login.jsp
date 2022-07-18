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
    </style>
</head>
<body>
<div class="bg"></div>
<div class="container col-xl-10 col-xxl-8 px-4 py-5">
    <div class="row align-items-center g-lg-5 py-5">
        <div class="col-lg-7 text-center text-lg-start"></div>
        <div class="col-md-10 mx-auto col-lg-5">
            <form class="p-3 p-md-5 border rounded-3 bg-light" action="${pageContext.request.contextPath}/to/login"
                  method="post">
                <c:if test="${requestScope.error!=null}">
                    <p class="text-danger">
                            ${requestScope.error}
                    </p>
                </c:if>

                <div class=" mb-3">
                    <input type="email" class="form-control" id="email" name="email" placeholder="请输入邮箱...">
                    <p class="text-danger">邮箱格式错误！</p>
                </div>
                <div class=" mb-3">
                    <input type="password" class="form-control" id="password" name="password" id="password"
                           placeholder="请输入密码...">
                    <p class="text-danger">密码长度4-20！</p>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="check" checked>
                    <label class="form-check-label mb-3" for="check">
                        记住我
                    </label>
                </div>
                <div class="d-grid gap-2">
                    <button class="btn btn-primary" type="submit">登录</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
