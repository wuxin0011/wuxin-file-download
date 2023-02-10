<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    header ul a:hover {
        text-decoration: underline !important;
    }

    header  ul a:active{
        color: teal;
        text-decoration: underline !important;
    }
</style>
<body>
<header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
    <ul class="nav col-8 col-md-auto mb-2 justify-content-center mb-md-0 fs-5">
        <li><a href="/" class="link-dark px-2 text-decoration-none ">首页</a></li>
        <li><a href="/notice" class="link-dark px-2 text-decoration-none">公告</a></li>
        <li><a href="${pageContext.request.contextPath}/message" class="link-dark px-2 text-decoration-none">留言</a></li>
    </ul>

    <div class="col-4 text-end">
        <c:if test="${sessionScope.loginUser ==null}">
            <a href="/login" class="btn btn-outline-primary btn-sm me-2 text-decoration-none">登录</a>
        </c:if>
        <c:if test="${sessionScope.loginUser!=null}">
            <a href="/admin/main" class="link-dark px-2  text-decoration-none">管理</a>
        </c:if>
        <a href="/register" class="btn btn-outline-primary btn-sm  me-2 text-decoration-none">注册</a>
    </div>
</header>
</body>

</html>