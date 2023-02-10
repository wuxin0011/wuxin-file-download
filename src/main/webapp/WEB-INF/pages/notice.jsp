<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>公告</title>
    <jsp:include page="common/headFile.jsp"/>
</head>


<body>

<div class="container col-xl-6 col-sm-12 col-xs-12 col-xxl-4 px-10 py-10 mt-5">
    <%@ include file="./common/header.jsp" %>
    <main class="col-12">
        <c:choose>
            <c:when test="${requestScope.r.code==200}">
                <c:choose>
                    <c:when test="${requestScope.r.data.size()!=0}">
                        <c:forEach items="${requestScope.r.data}" var="item">
                            <div class="card mt-4">
                                <h5 class="card-header fs-5">
                                    #<fmt:formatDate pattern="yyyy-MM-dd" value="${item.createTime}"/>
                                        &nbsp;${item.title}
                                </h5>
                                <div class="card-body btn-group-sm">
                                    <p class="card-text fs-6">${item.content}</p>
                                </div>
                            </div>
                        </c:forEach>
                    </c:when>

                    <c:otherwise>
                        <h2 class="text-dark fs-5">暂无公告！</h2>
                    </c:otherwise>
                </c:choose>

            </c:when>

            <c:otherwise>
                <h2 class="text-danger fs-5">数据加载失败！</h2>
            </c:otherwise>
        </c:choose>


        <div class="dropdown-divider"></div>
    </main>
    <%@ include file="./common/footer.jsp" %>
</div>

</body>

</html>