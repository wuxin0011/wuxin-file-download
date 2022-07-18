<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <meta charset="utf-8">
    <title>分类</title>
    <jsp:include page="common/headFile.jsp"/>
    <style>
        .main a::before {
            content: ' 📂 ';
        }
        .main a:hover{
            text-decoration: underline !important;
        }

        li {
            list-style: none;
        }
    </style>
</head>

<body>

<div class="container col-xl-6 col-sm-12 col-xs-12 col-xxl-4 px-10 py-10 mt-5">
    <%@ include file="./common/header.jsp" %>

    <section class="col-12  main">
        <ul>
            <c:forEach var="file" items="${requestScope.files}">
                <li class="mb-1 mt-1">
                    <a href="${file.url}" class="text-success text-decoration-none" download>${file.name}</a>
                </li>
            </c:forEach>
        </ul>
        <div class="dropdown-divider"></div>
    </section>
    <%@ include file="./common/footer.jsp" %>
</div>

</body>

</html>