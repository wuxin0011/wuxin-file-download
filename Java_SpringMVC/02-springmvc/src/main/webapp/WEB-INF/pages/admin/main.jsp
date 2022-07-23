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
        <c:when test="${requestScope.r.code==200}">
            <%--管理员--%>
            <c:if test="${sessionScope.loginUser.role==1}">
                <div class="card-body">
                    <c:choose>
                        <%--有内容--%>
                        <c:when test="${requestScope.r.data!=0}">
                            <h5 class="card-header  pt-b pb-2">
                                <p class="fs-5 ">
                                    亲爱的管理员: <a href="/admin/user/personal"
                                               class="text-primary text-decoration-underline ">${sessionScope.loginUser.username}</a>
                                </p>


                                <p class="fs-6 mt-1">
                                    您有<span class="text-danger">${requestScope.r.data}</span>条消息未读
                                    <a href="/admin/message" class="link-primary">点击查看</a>
                                </p>
                            </h5>

                        </c:when>
                        <%--无内容--%>
                        <c:otherwise>
                            <h4 class="text-success"> 欢迎
                                <a href="/admin/user/personal"
                                   class="text-primary text-decoration-underline">${sessionScope.loginUser.username}</a>，
                            </h4>
                        </c:otherwise>
                    </c:choose>

                </div>
            </c:if>
            <%--普通用户--%>
            <c:if test="${sessionScope.loginUser.status==0}">
                <div class="card-body">
                    <h4 class="text-success">
                        欢迎 <a href="/admin/user/personal"
                              class="text-primary text-decoration-underline">${sessionScope.loginUser.username}</a>，
                    </h4>
                </div>
            </c:if>
        </c:when>
        <c:otherwise>
            <h4 class="text-danger">加载失败！</h4>
        </c:otherwise>


    </c:choose>

</div>


</body>

</html>