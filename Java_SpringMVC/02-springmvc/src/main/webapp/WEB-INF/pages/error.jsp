<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>出错了！</title>
    <jsp:include page="common/headFile.jsp"/>
</head>


<body>
<div class="container col-xl-6 col-sm-12 col-xs-12 col-xxl-4 px-10 py-10 mt-5">

    <h3 class="mb-3 text-danger fs-5">
        出错了！
    </h3>
    <p class="mb-1 fs-6"> 状态码&nbsp;:&nbsp;
        <span class="text-danger">${requestScope.code}</span>
    </p>
    <p class="mb-1 fs-6 ">原因 &nbsp;:&nbsp;
        <span class="text-danger">${requestScope.message}</span>
        <c:if test="${requestScope.code==401}">
            <a href="/login" class="link-primary" style="margin-left: 10px;">登录</a>
        </c:if>
    </p>

    <p class="mb-1 fs-6 ">
        <a href="javascript:history.go(-1)" class="link-success">返回</a>
    </p>
    <div class="mb-2 mt-2">
        您可以通过邮箱联系我
        <span class="text-decoration-underline text-primary">2191377759@qq.com</span>
        或者通过
        <a href="/message" class="link-dark">留言板</a>
    </div>


</div>

</body>

</html>