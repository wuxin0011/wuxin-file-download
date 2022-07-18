<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>消息管理</title>
    <jsp:include page="../common/headFile.jsp"/>
</head>
<body>

<div class="container col-xl-6 col-sm-12 col-xs-12 col-xxl-4 px-10 py-10 mt-5">
    <jsp:include page="../common/admin/header.jsp"/>

    <section class="main">
        <!-- Nav tabs -->
        <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item" role="presentation">
                <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home"
                        type="button" role="tab" aria-controls="home" aria-selected="true">未读
                </button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile"
                        type="button" role="tab" aria-controls="profile" aria-selected="false">已读
                </button>
            </li>
        </ul>

        <c:choose>
            <c:when test="${requestScope.r.code==200}">
                <div class="tab-content">
                    <div class="tab-pane active" id="home" role="tabpanel" aria-labelledby="home-tab" tabindex="0">
                        <div class="message mt-4">
                            <c:forEach var="item" items="${requestScope.r.data}">
                                <c:if test="${item.status==0}">
                                    <div class="card mt-4">
                                        <h5 class="card-header" style="font-size: 16px;">${item.email}</h5>
                                        <div class="card-body btn-group-sm">
                                            <p class="card-text" style="font-size: 14px;">${item.content}</p>
                                            <button class="btn btn-primary btn-sm">已阅</button>
                                            <button type="button" class="btn btn-dark btn-sm" data-bs-toggle="modal"
                                                    data-bs-target="#exampleModal" data-bs-whatever="@mdo">回复
                                            </button>
                                            <button class="btn btn-danger btn-sm">删除</button>
                                        </div>
                                    </div>
                                </c:if>

                            </c:forEach>
                        </div>
                    </div>
                    <div class="tab-pane" id="profile" role="tabpanel" aria-labelledby="profile-tab" tabindex="0">
                        <div class="message mt-4">
                            <c:forEach var="item" items="${requestScope.r.data}">
                                <c:if test="${item.status==1}">
                                    <div class="card mt-4">
                                        <h5 class="card-header" style="font-size: 16px;">${item.email}</h5>
                                        <div class="card-body btn-group-sm">
                                            <p class="card-text" style="font-size: 14px;">${item.content}</p>
                                            <button class="btn btn-primary btn-sm">已阅</button>
                                            <button type="button" class="btn btn-dark btn-sm" data-bs-toggle="modal"
                                                    data-bs-target="#exampleModal" data-bs-whatever="@mdo">回复
                                            </button>
                                            <button class="btn btn-danger btn-sm">删除</button>
                                        </div>
                                    </div>
                                </c:if>

                            </c:forEach>
                        </div>
                    </div>
                </div>

            </c:when>
            <c:otherwise>
                <h2 class="text-danger">请求失败！</h2>
            </c:otherwise>
        </c:choose>
    </section>


    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">New message</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                            aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="mb-3">
                            <label for="recipient-name" class="col-form-label">Recipient:</label>
                            <input type="text" class="form-control" id="recipient-name">
                        </div>
                        <div class="mb-3">
                            <label for="message-text" class="col-form-label">Message:</label>
                            <textarea class="form-control" id="message-text"></textarea>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Send message</button>
                </div>
            </div>
        </div>
    </div>


</div>

</body>
</html>
