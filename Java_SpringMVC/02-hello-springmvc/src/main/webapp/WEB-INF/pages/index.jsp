<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>主页</title>
    <jsp:include page="common/headFile.jsp"/>
    <style>
        li {
            list-style: none;
        }

        main a::before {
            content: ' 📂 ';
        }

        main a:hover {
            text-decoration: underline !important;
        }
    </style>
</head>


<body>

<div class="container col-xl-6 col-sm-12 col-xs-12 col-xxl-4 px-10 py-10 mt-5">
    <%@ include file="./common/header.jsp" %>
    <main class="col-12">
        <ul>
            <c:forEach var="category" items="${requestScope.categoryList}">
                <li class="mt-1 mb-1">
                    <a href="/category/${category.cid}"
                       class=" link-dark text-decoration-none text-success">${category.name}</a>
                </li>
            </c:forEach>

        </ul>

        <div class="dropdown-divider"></div>
    </main>
    <%@ include file="./common/footer.jsp" %>
</div>

</body>

</html>