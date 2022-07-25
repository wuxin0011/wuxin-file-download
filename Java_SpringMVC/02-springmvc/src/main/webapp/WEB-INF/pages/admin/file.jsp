<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>文件管理</title>
    <jsp:include page="../common/headFile.jsp"/>
</head>
<body>
<div class="container col-xl-6 col-sm-12 col-xs-12 col-xxl-4 px-10 py-10 mt-5">
    <jsp:include page="../common/admin/header.jsp"/>
    <div class="table-container">

        <table class="table table-striped text-center fs-6 text-nowrap overflow-hidden">
            <div class="row-cols-6">
                <button type="button" class="btn btn-primary btn-sm col-2 mb-2" data-bs-target="#exampleModal"
                        data-bs-toggle="modal"
                        data-bs-cid="${item.cid}"
                        data-bs-type="add">添加
                </button>
                <div class="col-6 mb-2 ">
                    <select class="form-select " id="table-select" aria-label="${requestScope.page.keywords}">
                        <c:forEach var="category" items="${requestScope.categoryList}">
                            <c:choose>
                                <c:when test="${requestScope.page.keywords==category.cid}">
                                    <option value="${category.cid}" selected>${category.name}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${category.cid}">${category.name}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>


            </div>
            <thead>
            <tr>
                <th scope="col">序号</th>
                <th scope="col">名称</th>
                <th scope="col">分类</th>
                <th scope="col">日期</th>
                <th scope="col">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:choose>
                <c:when test="${requestScope.page.list.size()>0}">
                    <c:forEach var="item" items="${requestScope.page.list}">
                        <tr>
                            <th scope="row" class="col-1 ">${item.fid}</th>
                            <td class="col-2 ">
                                <a href="/category/${item.cid}" class="link-success "
                                   target="_blank">${item.name}</a>
                            </td>
                            <td class="col-2">
                                <a href="/category/${item.cid}" class="link-success "
                                   target="_blank">${item.cname}</a>
                            </td>
                            <td class="col-3 content">
                                <fmt:formatDate pattern="yyyy-MM-dd" value="${item.createTime}"/>
                            </td>
                            <td class="col-4  btn-group-sm">
                                <button type="button" class="btn btn-primary btn-sm"
                                        data-bs-target="#updateExample"
                                        data-bs-toggle="modal"
                                        data-bs-fid="${item.fid}"
                                        data-bs-name="${item.name}"
                                        data-bs-cid="${item.cid}"
                                        data-bs-type="update">修改
                                </button>
                                <button class="btn btn-danger btn-sm " onclick="deleteFile(${item.fid})">删除</button>
                            </td>
                        </tr>

                    </c:forEach>

                </c:when>
                <c:otherwise>
                    <tr>
                        <h4 class="text-dark fs-5">暂无数据！</h4>
                    </tr>

                </c:otherwise>
            </c:choose>
            </tbody>
        </table>
        <c:if test="${requestScope.page.list.size()>0}">
            <nav aria-label="${requestScope.page.limit}">
                <ul class="pagination">
                    <li class="page-item  ${requestScope.page.limit>0?'':'disabled'}">
                        <a class="page-link"
                           href="${pageContext.request.contextPath}/admin/file?keywords=1&limit=${requestScope.page.limit-1}&size=10"
                           tabindex="-1" aria-disabled="true">上页</a>
                    </li>

                    <c:forEach var="i" begin="1" end="${requestScope.page.totalPage}">
                        <li class="page-item ${i==requestScope.page.limit?'active':''}">
                            <a class="page-link" aria-current="page"
                               href="${pageContext.request.contextPath}/admin/file?keywords=1&limit=${i}&size=10">${i}</a>
                        </li>
                    </c:forEach>


                    <li class="page-item ${requestScope.page.limit<requestScope.page.totalPage?'':'disabled'}">
                        <a class="page-link"
                           href="${pageContext.request.contextPath}/admin/file?keywords=1&limit=${requestScope.page.limit+1}&size=10"
                           tabindex="-1"
                           aria-disabled="true">下一页</a>
                    </li>

                    <li class="page-item ">
                        <span class="page-link">共 ${requestScope.page.total}条数据</span>
                    </li>

                </ul>
            </nav>

        </c:if>

    </div>


    <div class="modal fade" id="exampleModal" tabindex="1" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content" id="uploadForm">
                <div class="modal-header">
                    <h5 class="modal-title fs-6" id="exampleModalLabel">文件上传</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="name" class="col-form-label">文件名</label>
                        <input type="text" class="form-control" name="name" id="name" required>
                    </div>
                    <div class="mb-3 col-4">
                        <label class="col-form-label">分类</label>
                        <select class="form-select  mb-2 " id="selectCategory" name="cid">
                            <c:forEach var="category" items="${requestScope.categoryList}">
                                <c:choose>
                                    <c:when test="${requestScope.page.keywords==category.cid}">
                                        <option value="${category.cid}" selected>${category.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${category.cid}">${category.name}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="mb-3">
                        <label for="file" class="col-form-label">文件上传</label>
                        <input type="file" name="file" class="form-control" id="file"
                               aria-describedby="inputGroupFileAddon04" aria-label="Upload">
                    </div>

                </div>
                <div class="modal-footer btn-group-sm">
                    <button type="button" class="btn btn-secondary " data-bs-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="submitAddBtn">确认</button>
                </div>
            </div>
        </div>
    </div>


    <div class="modal fade" id="updateExample" tabindex="2" aria-labelledby="updateFileModalExample"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title fs-6">文件属性</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="newFileName" class="col-form-label">文件名:</label>
                        <input type="text" class="form-control" name="name" id="newFileName" required>
                    </div>
                    <div class="mb-3 col-4">
                        <label class="col-form-label" for="newCategory"
                               aria-label="${requestScope.page.keywords}">分类:</label>
                        <select class="form-select  mb-2 " id="newCategory" name="cid">
                            <c:forEach var="category" items="${requestScope.categoryList}">
                                <c:choose>
                                    <c:when test="${requestScope.page.keywords==category.cid}">
                                        <option value="${category.cid}" selected>${category.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${category.cid}">${category.name}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>

                        </select>
                    </div>
                </div>
                <div class="modal-footer btn-group-sm">
                    <button type="button" class="btn btn-secondary " data-bs-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary" id="submitUpdateBtn">确认</button>
                </div>
            </div>
        </div>
    </div>

</div>
<script type="text/javascript">

    window.onload = () => {
        const exampleModal = document.getElementById('exampleModal')
        const tableSelect = document.getElementById('table-select')

        exampleModal.addEventListener('show.bs.modal', event => {
            // 获取触发的button对象
            const button = event.relatedTarget

            let nameInput = exampleModal.querySelector('#name')
            let selectCategory = exampleModal.querySelector('#selectCategory')
            let cid = button.getAttribute('data-bs-cid')

            // 监听选择框改变事件
            selectCategory.addEventListener('change', function (e) {
                cid = e.target.value * 1
            })

            // 提交
            exampleModal.querySelector('#submitAddBtn').addEventListener('click', function (e) {
                let name = nameInput.value.trim();
                let file = $('div.modal #file')[0].files

                if (!name) {
                    alert('请输入文件名！')
                    return;
                }



                if (file.length <= 0) {
                    alert('请选择图片后再上传！')
                    return;
                }

                addFile(name, cid, file[0])
            })


        })

        if (tableSelect) {
            tableSelect.addEventListener('change', function (e) {

                list(e.target.value, 0)
            })

        }


        const updateExample = document.getElementById('updateExample')
        updateExample.addEventListener('show.bs.modal', event => {
            // 获取触发的button对象
            const button = event.relatedTarget
            const modalName = updateExample.querySelector('#newFileName')
            const category = updateExample.querySelector('#newCategory')

            // 获取属性
            const fid = button.getAttribute('data-bs-fid')
            const fileName = button.getAttribute('data-bs-name')
            let cid = button.getAttribute('data-bs-cid')


            modalName.value = fileName


            // 监听选择框改变事件
            category.addEventListener('change', function (e) {
                cid = e.target.value * 1
            })

            // 提交
            updateExample.querySelector('#submitUpdateBtn').addEventListener('click', function (e) {
                let name = modalName.value.trim();
                if (!name) {
                    alert('请输入文件名！')
                    return;
                }
                if (fid === null || fid === undefined || fid === 0) {
                    alert('文件序号获取失败！')
                    return;
                }
                if (cid === null || cid === undefined || cid === 0) {
                    alert('文件类型获取失败！')
                    return;
                }

                updateFile(fid, name, cid)
            })


        })


    }

    function list(cid, limit) {
        window.location.href = '/admin/file?keywords=' + cid + "&limit=" + limit + "&size=10"
    }


    function addFile(name, cid, file) {
        if (!confirm('确认上传？')) {
            return;
        }
        var formData = new FormData();
        formData.append("name", name)
        formData.append("cid", cid)
        formData.append("file", file)



        $.ajax({
            url: '/admin/file/add',
            method: 'post',
            dataType: 'json',
            contentType: false,
            processData: false,
            data: formData,

            success: function (result) {
                if (result.code === 200) {
                    alert('上传成功！')
                    setTimeout(() => {
                        window.location.reload()
                    }, 1000)
                } else {
                    alert(result.message)
                }
            },
            error: function (e) {

                alert('操作失败！可能无权限执行该操作！')
            },

        })

    }


    function updateFile(fid, name, cid) {
        if (!confirm('确认修改？')) {
            return;
        }
        $.ajax({
            url: '/admin/file/update',
            type: 'post',
            dataType: 'json',
            data: {fid, name, cid},
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
                alert('操作失败！可能无权限执行该操作！')
            },

        })

    }

    function deleteFile(fid) {
        if (fid === null || fid === undefined || fid === 0) {
            alert('文件序号获取失败！')
            return;
        }
        if (!confirm('确认删除？' + fid)) {
            return;
        }
        $.ajax({
            url: '/admin/file/delete/' + fid,
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
                alert('操作失败！可能无权限执行该操作！')
            },

        })

    }

</script>

</body>
</html>
