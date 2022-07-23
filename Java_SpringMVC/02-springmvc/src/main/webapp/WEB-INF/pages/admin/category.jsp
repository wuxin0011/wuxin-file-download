<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>后台管理</title>
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
        <button type="button" class="btn btn-primary btn-sm col-2" data-bs-target="#noticeModal" data-bs-toggle="modal"
                data-bs-type="add">添加
        </button>
        <table class="table table-striped text-center overflow-hidden">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">名称</th>
                <th scope="col">文件数量</th>
                <th scope="col">操作</th>
            </tr>
            </thead>

            <tbody>
            <c:choose>
            <c:when test="${requestScope.r.code==200}">
            <c:choose>
            <c:when test="${requestScope.r.data.size() !=0}">
            <tbody>
            <c:forEach var="item" items="${requestScope.r.data}">
                <tr>
                    <th scope="row" class="col-2 ">${item.cid}</th>
                    <td class="col-3 ">
                        <a href="/category/${item.cid}">${item.name}</a>
                    </td>

                    <td class="col-3 content">${item.count}</td>
                    <td class="col-4 btn-group-sm">
                        <button type="button" class="btn btn-primary  "
                                data-bs-target="#noticeModal"
                                data-bs-toggle="modal"
                                data-bs-type="update" data-bs-id="${item.cid}"
                                data-bs-name="${item.name}">修改
                        </button>
                        <button class="btn btn-danger" onclick="deleteCategory(${item.cid})">删除</button>
                    </td>
                </tr>

            </c:forEach>
            </tbody>
            </c:when>
            <c:otherwise>
                <h4 class="text-dark fs-5">暂无数据！</h4>
            </c:otherwise>
            </c:choose>
            </c:when>
            <c:otherwise>
                <h4 class="text-danger fs-5">请求失败！</h4>
            </c:otherwise>

            </c:choose>
            </tbody>


        </table>
    </div>

    <div class="modal fade" id="noticeModal" tabindex="-1" aria-labelledby="noticeModal"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modal-title">分类</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                            aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="category-name" class="col-form-label">名称</label>
                        <input type="text" name="title" class="form-control" id="category-name" required>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary btn-sm" data-bs-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary btn-sm" id="submitNoticeBtn">提交</button>
                </div>
            </div>

        </div>
    </div>


</div>

<script>
    const noticeModal = document.getElementById('noticeModal')
    noticeModal.addEventListener('show.bs.modal', event => {
        // 获取触发的button对象
        const button = event.relatedTarget
        const eventType = button.getAttribute('data-bs-type')
        const modalInputTitle = noticeModal.querySelector('#modal-title')
        const modalInputName = noticeModal.querySelector('#category-name')

        const varTitle = eventType === 'update' ? '修改' : '添加'

        // 重置
        modalInputName.value = ''
        var cid;
        // 判断事件类型
        if (eventType === 'update') {
            cid = button.getAttribute('data-bs-id')
            const varName = button.getAttribute('data-bs-name')

            modalInputName.value = varName
        }

        modalInputTitle.textContent = varTitle + '分类'


        document.querySelector("#submitNoticeBtn").addEventListener('click', () => {

            var name = modalInputName.value.trim();
            if (name.length === 0) {
                alert("标签名称不能为空！")
                return;
            }


            if (!confirm('确认' + varTitle)) {
                return;
            }


            if (eventType === 'update') {
                update(cid, name)
            }else {
                add(name)
            }

        })


    })


    function add(name) {
        $.ajax({
            url: '/admin/category/add',
            type: 'post',
            dataType: 'json',
            data: {'name': name},
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
                alert('添加失败')
            },

        })

    }

    function deleteCategory(cid) {
        if (!confirm('确认删除？该操作不可回复！')) {
            return;
        }
        $.ajax({
            url: '/admin/category/delete/' + cid,
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
                alert('删除失败')
            },

        })

    }


    function update(cid, name) {
        $.ajax({
            url: '/admin/category/update',
            type: 'post',
            dataType: 'json',
            data: {'cid': cid, 'name': name},
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
                alert('修改失败')
            },

        })

    }


</script>

</body>
</html>
