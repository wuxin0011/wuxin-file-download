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
                            <td class="col-2 link-primary text-decoration-underline ">${user.username}</td>
                            <td class="col-3 text-success">${user.email}</td>
                            <td class="col-2"><fmt:formatDate value="${user.createTime}" pattern="yyyy/MM/dd"/></td>
                            <td class="col-4 btn-group-sm">
                                <button type="button"
                                        class="btn btn-primary btn-sm"
                                        data-bs-toggle="modal"
                                        data-bs-target="#exampleModal"
                                        data-bs-id="${user.id}"
                                        data-bs-username="${user.username}"
                                        data-bs-email="${user.email}"
                                        data-bs-status="${user.status}"
                                        data-bs-role="${user.role}"
                                >编辑
                                </button>
                                <button class="btn btn-sm ${user.status==0?"btn-success":"btn-dark"}"
                                        onclick="updateUserStatus(${user.id},${user.status})">${user.status==0?"恢复":"禁用"}
                                </button>
                                <button class="btn btn-danger btn-sm " onclick="deleteUser(${user.id})">删除</button>
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
                        <label for="username" class="col-form-label">用户名:</label>
                        <input type="text" class="form-control" id="username">
                    </div>
                    <div class="mb-3">
                        <label for="email" class="col-form-label">邮箱:</label>
                        <input type="text" class="form-control" id="email">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="col-form-label">密码:</label>
                        <input type="text" class="form-control" id="password">
                    </div>
                    <div class="mb-3">
                        <input type="radio" class="radio" name="role" value="0" id="roleuser">用户
                        <input type="radio" class="radio" name="role" value="1" id="roleadmin">管理员
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

        const id = button.getAttribute('data-bs-id')
        const email = button.getAttribute('data-bs-email')
        const username = button.getAttribute('data-bs-username')
        const status = button.getAttribute('data-bs-status')
        var role = button.getAttribute('data-bs-role')



        const recipient_name = exampleModal.querySelector('#username')
        const recipient_email = exampleModal.querySelector('#email')
        const recipient_password = exampleModal.querySelector('#password')
        // 判断事件类型
        recipient_name.value = username
        recipient_email.value = email

        const roleadmin = exampleModal.querySelector('#roleadmin')
        const roleuser = exampleModal.querySelector('#roleuser')

        if (parseInt(role) === 1) {
            roleadmin.setAttribute('checked', 'checked')
        } else {
            roleuser.setAttribute('checked', 'checked')
        }


        document.querySelector("#roleadmin").addEventListener('change', () => {

            role = 1;

        })

        document.querySelector("#roleuser").addEventListener('change', () => {


            role = 0;

        })


        document.querySelector("#updateUserBtn").addEventListener('click', () => {
            var newUsername = recipient_name.value.trim();
            var newEmail = recipient_email.value.trim();
            var newPassword = recipient_password.value.trim();

            if (newUsername.length < 4 || newUsername.length > 15) {
                alert("请填写用户名,长度在2-15")
                return
            }

            if (!newEmail) {
                alert("请填写邮箱")
                return
            }
            if (newPassword) {
                if (newPassword.length < 4 || newPassword.length > 20) {
                    alert("请填写密码,密码长度4-20")
                    return
                }
            }


            update(id, newUsername, newEmail, newPassword, role)


        })


    })


    function updateUserStatus(id, status) {
        if (status === 0) {
            status = 1
        } else {
            status = 0
        }
        $.ajax({
            url: '/admin/user/update/status',
            type: 'post',
            dataType: 'json',
            data: {"id": id, "status": status},
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


    function update(id, username, email, password, role) {
        var dataJSON = JSON.stringify({
            'id': id,
            'username': username,
            'email': email,
            'password': password,
            role: role
        })
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

                alert('修改失败！服务器异常！')
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
