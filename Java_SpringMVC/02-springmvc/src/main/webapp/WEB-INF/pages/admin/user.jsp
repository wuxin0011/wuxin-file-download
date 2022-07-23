<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <title>用户管理</title>
    <jsp:include page="../common/headFile.jsp"/>
    <style type="text/css">
        .content {
            overflow: hidden !important;
        }
    </style>
</head>
<body>
<div class="container col-xl-6 col-sm-12 col-xs-12 col-xxl-4 px-10 py-10 mt-5">
    <jsp:include page="../common/admin/header.jsp"/>
    <div class="table-container">
        <div class="mb-2">
            <form class="form-inline" method="get" action="/admin/user">
                <input class="form-control mr-sm-2 w-100" type="search" placeholder="Search keywrods ..."
                       aria-label="Search">
            </form>
        </div>
        <c:choose>
            <c:when test="${requestScope.userList.size()!=0}">
                <table class="table table-striped text-center overflow-hidden fs-6">
                    <thead>
                    <tr>
                        <th scope="col ">#</th>
                        <th scope="col">用户</th>
                        <th scope="col ">邮箱</th>
                        <th scope="col ">日期</th>
                        <th scope="col ">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${requestScope.userList}" var="user" varStatus="index">
                        <tr>
                            <th scope="row" class="col-1">${user.id}</th>
                            <td class="col-2 ">${user.username}</td>
                            <td class="col-4">${user.email}</td>
                            <td class="col-4 text-start">
                                <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal"
                                        data-bs-target="#exampleModal" data-bs-whatever="${user}">编辑
                                </button>
                                <c:if test="${user.status==1}">
                                    <button class="btn btn-dark btn-sm" onclick="updateUser(${user})">禁用</button>
                                </c:if>
                                <c:if test="${user.status==0}">
                                    <button class="btn btn-success btn-sm" onclick="updateUser(${user})">恢复</button>
                                </c:if>
                                <button class="btn btn-danger btn-sm" onclick="deleteUser(${user.id})">删除</button>
                            </td>
                        </tr>

                    </c:forEach>
                    </tbody>
                </table>

            </c:when>
            <c:otherwise>
                <h5 class="text-dark">暂无用户数据！</h5>
            </c:otherwise>
        </c:choose>
    </div>


    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">编辑</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label">用户名:</label>
                        <input type="text" class="form-control" id="recipient-name">
                    </div>
                    <div class="mb-3">
                        <label for="recipient-email" class="col-form-label">邮箱:</label>
                        <input type="text" class="form-control" id="recipient-email">
                    </div>
                    <div class="mb-3">
                        <label for="recipient-password" class="col-form-label">密码:</label>
                        <input type="text" class="form-control" id="recipient-password">
                    </div>
                    <div class="mb-3">
                        <label class="col-form-label">角色:</label>
                        <input type="radio" class="form-control" name="radio" value="0">用户
                        <input type="radio" class="form-control" name="radio" value="1">管理员
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="updateUserBtn">修改</button>
                </div>
            </div>
        </div>
    </div>


</div>
<script>
    const exampleModal = document.getElementById('exampleModal')
    exampleModal.addEventListener('show.bs.modal', event => {
        // 获取触发的button对象
        const button = event.relatedTarget
        const user = button.getAttribute('data-bs-whatever')
        if (!user) {
            alert('获取不到用户信息')
            return
        }
        console.log('user', JSON.stringify(user))
        const recipient_name = exampleModal.querySelector('#recipient-name')
        const recipient_email = exampleModal.querySelector('#recipient-email')
        const recipient_password = exampleModal.querySelector('#recipient-password')
        // 判断事件类型
        recipient_name.value = user.username
        recipient_email.value = user.email
        recipient_password.value = user.password

        document.querySelector("#updateUserBtn").addEventListener('click', () => {
            var username = recipient_name.value.trim();
            var email = recipient_email.value.trim();
            var password = recipient_password.value.trim();
            if (username.length < 4 || username.length > 15) {
                alert("请填写用户名,长度在2-15")
                return
            }

            if (email.length === 0) {
                alert("请填写邮箱")
                return
            }
            if (password.length !== 0 || (password.length < 4 || password.length > 20)) {
                alert("请填写密码,密码长度4-20")
                return
            }

            update(user.id, username, email, password)


        })


    })

    function updateUser(user) {
        alert('updateUser===>' + JSON.stringify(user))
        if (!user) {
            alert('获取不到用户信息')
            return
        }
        if (user.status === 0) {
            user.status = 1
        } else {
            user.status = 0
        }
        update(user.id, user.username, user.email, user.password)
    }


    function update(id, username, email, password) {
        var dataJSON = JSON.stringify({'id': id, 'username': username, 'email': email, 'password': password})
        $.ajax({
            url: '/admin/user/update',
            type: 'post',
            contentType: 'application/json',
            dataType: 'json',
            data: dataJSON,
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
                console.log(e)
            },

        })

    }


    function deleteUser(id) {
        $.ajax({
            url: '/admin/user/delete/' + id,
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
