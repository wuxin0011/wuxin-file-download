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
    </style>
</head>
<body>
<div class="bg"></div>
<div class="container col-xl-10 col-xxl-8 px-4 py-5">
    <div class="row align-items-center g-lg-5 py-5">
        <div class="col-lg-7 text-center text-lg-start">
        </div>
        <div class="col-md-10 mx-auto col-lg-5">
            <form class="p-4 p-md-5 border rounded-3 bg-light" action="/user/register" method="post">
                <div class=" mb-2">

                    <input type="email" class="form-control" name="email" id="email" placeholder="xx@xxx.com" required>
                    <%--                    <c:if test="${requestScope.error!=null}">--%>
                    <%--                        <p class="text-danger">--%>
                    <%--                                ${requestScope.error}--%>
                    <%--                        </p>--%>
                    <%--                    </c:if>--%>
                    <p class="text-danger">邮箱已经被注册了哦</p>
                </div>
                <div class=" mb-2">
                    <input type="password" class="form-control" id="password" name="password" placeholder="密码"
                           required>
                    <p class="text-danger">密码已经被使用了哦</p>
                </div>
                <div class=" mb-2">
                    <input type="password" class="form-control" id="repassword" name="repassword" placeholder="密码验证"
                           required>
                    <p class="text-danger">密码格式不一致！</p>
                </div>
                <div class="d-grid gap-2">
                    <button class="btn btn-primary" type="submit">注册</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
