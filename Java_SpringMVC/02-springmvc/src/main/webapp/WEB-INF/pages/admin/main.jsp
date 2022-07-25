<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <title>后台管理</title>
    <jsp:include page="../common/headFile.jsp"/>
</head>

<body>
<div class="container col-xl-6 col-sm-12 col-xs-12 col-xxl-4 px-10 py-10 mt-5">
    <jsp:include page="../common/admin/header.jsp"/>
    <c:choose>
        <c:when test="${sessionScope.loginUser.role==1}">
            <div class="card-body">
                <h5 class="card-header  pt-b pb-2">
                    <p class="fs-5 ">
                        亲爱的管理员: <a href="${pageContext.request.contextPath}/admin/user/personal"
                                   class="text-primary text-decoration-underline ">${sessionScope.loginUser.username}</a>
                    </p>
                </h5>
                <div class="card-body">
                    <c:choose>
                            <c:when test="${requestScope.r.code==200 && requestScope.r.data!=0 }">
                                您有<span class="text-danger">${requestScope.r.data}</span>条消息未读
                                <a href="${pageContext.request.contextPath}/admin/message" class="link-primary">点击查看</a>
                            </c:when>
                            <c:when test="${requestScope.r.code==200 && requestScope.r.data==0 }">
                                <a href="${pageContext.request.contextPath}/admin/message" class="link-primary">点击查看历史消息</a>
                            </c:when>
                            <c:otherwise>
                                <h4 class="text-danger">内容加载失败！</h4>
                            </c:otherwise>

                    </c:choose>

                </div>
            </div>
        </c:when>
        <c:otherwise>
            <h4 class="text-success"> 欢迎
                <a href="${pageContext.request.contextPath}/admin/user/personal"
                   class="text-primary text-decoration-underline">${sessionScope.loginUser.username}</a>，
            </h4>
        </c:otherwise>
    </c:choose>

</div>
</body>
</html>