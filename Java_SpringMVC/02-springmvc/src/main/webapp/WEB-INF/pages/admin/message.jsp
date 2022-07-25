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
                                        <h5 class="card-header fs-6">${item.email}</h5>
                                        <div class="card-body btn-group-sm ">
                                            <p class="card-text bd-highlight">${item.content}</p>
                                            <p class="card-text"><fmt:formatDate
                                                    pattern="yyyy-MM-dd HH-mm" value="${item.createTime}"/></p>

                                        </div>
                                        <div class="card-footer btn-group-sm">
                                            <button class="btn btn-primary " onclick="changeStatus(${item.mid})">已阅
                                            </button>
                                            <button type="button" class="btn btn-dark " data-bs-toggle="modal"
                                                    data-bs-target="#exampleModal" data-bs-whatever="${item}">回复
                                            </button>
                                            <button class="btn btn-danger" onclick="deleteMessage(${item.mid})">
                                                删除
                                            </button>
                                        </div>
                                    </div>
                                </c:if>

                            </c:forEach>
                        </div>
                    </div>
                    <div class="tab-pane" id="profile" role="tabpanel" aria-labelledby="profile-tab" tabindex="1">
                        <div class="message mt-4">
                            <c:forEach var="item" items="${requestScope.r.data}">
                                <c:if test="${item.status==1}">
                                    <div class="card mt-4">
                                        <h5 class="card-header fs-6">${item.email}</h5>
                                        <div class="card-body btn-group-sm">
                                            <p class="card-text fs-6">${item.content}</p>
                                            <p class="card-text fs-6"><fmt:formatDate
                                                    pattern="yyyy-MM-dd HH-mm" value="${item.createTime}"/></p>

                                        </div>
                                    </div>
                                    <div class="card-footer btn-group-sm">
                                        <button type="button" class="btn btn-dark " data-bs-toggle="modal"
                                                data-bs-target="#exampleModal" data-bs-whatever="${item}">回复
                                        </button>
                                        <button class="btn btn-danger " onclick="deleteMessage(${item.mid})">删除</button>
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


    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">回复</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="content" class="col-form-label">内容:</label>
                        <input type="text" name="content" class="form-control" id="content" readonly>
                    </div>
                    <div class="mb-3">
                        <label for="reply" class="col-form-label">你的回复:</label>
                        <textarea class="form-control" id="reply" name="reply"></textarea>
                    </div>
                </div>
                <div class="modal-footer btn-group-sm">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" id="submitNoticeBtn">提交</button>
                </div>
            </div>
        </div>
    </div>


</div>

<script>
    const exampleModal = document.getElementById('exampleModal')
    exampleModal.addEventListener('show.bs.modal', event => {

        const button = event.relatedTarget

        const messageData = button.getAttribute('data-bs-whatever')

        const {mid, content, email} = messageData

        const modalTitle = exampleModal.querySelector('#exampleModalLabel')
        const modalContent = exampleModal.querySelector('#content')
        const modalReply = exampleModal.querySelector('#reply')

        modalTitle.textContent = '来自' + email + '的消息'
        modalContent.value = content
        // // 判断事件类型

        document.querySelector("#submitNoticeBtn").addEventListener('click', () => {
            var reply = modalReply.value.trim();
            if (reply.length === 0) {
                alert("内容不能为空！")
                return
            }

            //     提交消息 ...

        })


    })


    function changeStatus(mid) {

        $.ajax({
            url: '/admin/message/update/status',
            type: 'post',
            dataType: 'json',
            data: {'mid': mid},
            success: function (result) {
                if (result.code === 200) {
                    setTimeout(() => {
                        window.location.reload()
                    }, 1000)
                } else {
                    alert(result.message)
                }
            },
            error: function (e) {
                alert('修改失败！')
            },

        })

    }


    function deleteMessage(mid) {
        if (!confirm('确认删除？')) {
            return;
        }
        $.ajax({
            url: '/admin/message/delete/' + mid,
            type: 'get',
            dataType: 'json',
            success: function (result) {
                if (result.code === 200) {
                    alert(result.message)
                    setTimeout(() => {
                        window.location.reload()
                    }, 1000)
                } else {
                    alert(result.message)
                }
            },
            error: function (e) {

            },

        })

    }


</script>


</body>
</html>
