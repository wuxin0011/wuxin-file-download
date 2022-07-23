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
                        data-bs-type="add" style="display: inline-block">添加
                </button>
                <select class="form-select col-4 mb-2" style="display: inline-block">
                    <c:forEach var="category" items="${requestScope.categoryList}">
                        <option value="${category.cid}">${category.name}</option>
                    </c:forEach>
                </select>

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
                                data-bs-target="#exampleModal"
                                data-bs-toggle="modal"
                                data-bs-fid="${item.fid}"
                                data-bs-name="${item.name}"
                                data-bs-url="${item.url}"
                                data-bs-cid="`${item.cid}"
                                data-bs-cname="${item.cname}"
                                data-bs-type="update">修改
                        </button>
                        <button class="btn btn-danger btn-sm " onclick="deleteFile(${item.fid})">删除</button>
                    </td>
                </tr>

            </c:forEach>

            </tbody>
        </table>
        <c:if test="${requestScope.page.total>0}">
            <nav aria-label="${requestScope.page.limit}">
                <ul class="pagination">
                    <li class="page-item  ${requestScope.page.limit>0?'':'disabled'}">
                        <a class="page-link"
                           href="${pageContext.request.contextPath}/admin/file/list?keywords=1&limit=${requestScope.page.limit-1}&size=10"
                           tabindex="-1" aria-disabled="true">上页</a>
                    </li>

                    <c:forEach var="i" begin="1" end="${requestScope.page.totalPage}">
                        <li class="page-item ${i==requestScope.page.limit?'active':''}">
                            <a class="page-link ${item==requestScope.page.limit?'active':''}" aria-current="page"
                               href="${pageContext.request.contextPath}/admin/file/list?keywords=1&limit=${i}&size=10">${i}</a>
                        </li>
                    </c:forEach>


                    <li class="page-item ${requestScope.page.limit<requestScope.page.totalPage?'':'disabled'}">
                        <a class="page-link"
                           href="${pageContext.request.contextPath}/admin/file/list?keywords=1&limit=${requestScope.page.limit+1}&size=10"
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
            <form class="modal-content" id="uploadForm" enctype="multipart/form-data" method="post" action="/admin/file/add">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">文件上传</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="name" class="col-form-label">文件名</label>
                        <input type="text" class="form-control" name="name" id="name" required>
                    </div>
                    <div class="mb-3">
                        <label class="col-form-label">分类</label>
                        <select class="form-select col-4 mb-2 " style="display: inline-block">
                            <c:forEach var="category" items="${requestScope.categoryList}">
                                <option value="${category.cid}">${category.name}</option>
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
                    <button type="submit" class="btn btn-primary" >确认</button>
                </div>
            </form>
        </div>
    </div>

    <div class="modal fade" id="exampleModal" tabindex="1" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <form class="modal-content" id="uploadForm1" enctype="multipart/form-data" method="post" action="/admin/file/add">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel1">文件上传</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="name" class="col-form-label">文件名</label>
                        <input type="text" class="form-control" name="name" id="name1" required>
                    </div>
                    <div class="mb-3">
                        <label for="url" class="col-form-label">文件地址</label>
                        <input type="text" class="form-control" name="url" id="url1" required>
                    </div>
                    <div class="mb-3">
                        <label class="col-form-label">分类</label>
                        <select class="form-select col-4 mb-2 " style="display: inline-block">
                            <c:forEach var="category" items="${requestScope.categoryList}">
                                <option value="${category.cid}">${category.name}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="mb-3">
                        <label for="file" class="col-form-label">文件上传</label>
                        <input type="file" name="file" class="form-control" id="file1"
                               aria-describedby="inputGroupFileAddon04" aria-label="Upload">
                    </div>

                </div>
                <div class="modal-footer btn-group-sm">
                    <button type="button" class="btn btn-secondary " data-bs-dismiss="modal">关闭</button>
                    <%--                    <button type="button" class="btn btn-primary" id="submitBtn">确认</button>--%>
                    <button type="submit" class="btn btn-primary" >确认</button>
                </div>
            </form>
        </div>
    </div>

</div>
<script type="text/javascript">
    const exampleModal = document.getElementById('exampleModal')
    exampleModal.addEventListener('show.bs.modal', event => {
        // 获取触发的button对象
        const button = event.relatedTarget

        const eventType = button.getAttribute('data-bs-type')

        const  modalUrl = exampleModal.querySelector('#url')
        const modalName = exampleModal.querySelector('#name')
        const modalFile = exampleModal.querySelector('#file')
        const modalTitle = exampleModal.querySelector('#exampleModalLabel')


        // modalUrl.add



        if (eventType === 'update') {

        }else {

        }


        const varTitle = eventType === 'update' ? '修改' : '添加'
        var fid;
        // 判断事件类型
        if (eventType === 'update') {
            fid = button.getAttribute('data-bs-id')
            const data_name = button.getAttribute('data-bs-name')
            const data_url = button.getAttribute('data-bs-url')


            modalName.value = data_name
            modalUrl.value = data_url

        }
        modalTitle.textContent = varTitle + '文件'


        $('#submitBtn').click(function (e) {
            var name = modalName.value.trim();
            var url = modalUrl.value.trim();
            var file = modalFile.value.trim();
            if (eventType === 'update') {
                update(fid, name)
            } else {
                add(name, file)
            }
        })

        $('table select').click(function (e) {
            console.log('table select', e.target.value)
            list(e.target.value, 0)
        })


        $('#exampleModal select').click(function (e) {
            console.log('exampleModal select', e.target.value)
        })


    })


    function list(cid, limit) {
        window.location.href = '/admin/file/list?keywords=' + cid + "&limit=" + limit + "&size=10"
    }


    function add(name, file) {

        console.log(name,file)

        $.ajax({
            url: '/admin/file/add',
            type: 'post',
            contentType: 'multipart/form-data',
            processData: 'false',
            cache:false,
            dataType: 'json',
            data: {'name':name,"file":file},
            success: function (result) {
                if (result.code === 200) {
                    alert('添加成功')
                    setTimeout(() => {
                        window.location.reload()
                    }, 1000)
                } else {
                    alert(result.message)
                }
            },
            error: function (e) {
              alert('上传失败！')
            },

        })

    }

    function update(fid,name,url,file) {
        console.log('update ...')
        return

        var dataJSON = JSON.stringify({fid,name,url,file})
        $.ajax({
            url: '/admin/file/update',
            type: 'post',
            contentType: 'multipart/form-data',
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


    function deleteFile(fid) {
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

            },

        })

    }


</script>

</body>
</html>
