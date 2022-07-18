<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <title>后台管理</title>
    <jsp:include page="../common/headFile.jsp"/>
</head>

<body>
<div class="container col-xl-6 col-sm-12 col-xs-12 col-xxl-4  mt-5">
    <jsp:include page="../common/admin/header.jsp"/>

    <h1>${requestScope.r}</h1>
    <div class="message mt-4">
        <div class="card mt-4">
            <div class="card-body">
                <p class="card-text">亲爱的管理员 ${requestScope.r.username}，您有<span class="
							text-danger">${requestScope.r.data}</span>条消息未读</p>
                <a href="/admin/message" class="link-primary">点击查看</a>
            </div>
        </div>
    </div>

</div>


</body>

</html>