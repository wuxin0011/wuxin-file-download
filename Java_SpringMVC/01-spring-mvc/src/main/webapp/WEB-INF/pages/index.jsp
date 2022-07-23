<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>index</title>
</head>
<body>
<p>${requestScope}</p>
<c:forEach var="item" items="${requestScope.list}">
    <a href="/index">${item.name}</a>
</c:forEach>

<br/>
<hr/>

<form action="/upload" method="post" enctype="multipart/form-data" >
    <input type="file" name="file">
    <br/>
    <button type="submit">submit</button>
</form>
</body>
</html>
