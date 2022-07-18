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
        <button type="button" class="col-3 btn btn-primary btn-sm mb-4" data-bs-toggle="modal"
                data-bs-target="#uploadFileModal" data-bs-whatever="@mdo">添加文件
        </button>
        <form class="form-inline mb-4">
            <input class="form-control col-6 " type="search" name="keywords" placeholder="Search"
                   aria-label="Search">
        </form>
        <c:if test="${requestScope.r.code==200}">
            <table class="table table-striped">
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
                <c:forEach var="item" items="${requestScope.r.data}">
                    <tr>
                        <th scope="row" class="col-1 content">${item.fid}</th>
                        <td class="col-2 content">
                            <a href="/category/${item.cid}" class="link-success overflow-hidden"
                               target="_blank">${item.name}</a>
                        </td>
                        <td class="col-2">
                            <label class="btn btn-success btn-sm">${item.cname}</label>
                        </td>
                        <td class="col-4 content">
                            <fmt:formatDate pattern="yyyy-MM-dd" value="${item.createTime}"/>
                        </td>
                        <td class="col-2">
                            <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal"
                                    data-bs-target="#exampleModal" data-bs-whatever="@mdo">编辑
                            </button>
                            <button class="btn btn-danger btn-sm" onclick="deleteFile()">删除</button>
                        </td>
                    </tr>

                </c:forEach>


                </tbody>
            </table>
        </c:if>
        <c:if test="${requestScope.r.code!=200}">
            <h2 class="text-danger">
                数据获取失败！
            </h2>
        </c:if>
    </div>


    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">文件上传</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="${pageContext.request.contextPath}/admin/file/upload" method="post"
                          enctype="multipart/form-data">
                        <div class="mb-3">
                            <label for="name" class="col-form-label">文件名</label>
                            <input type="text" class="form-control" name="name" id="name" required>
                        </div>
                        <div class="mb-3">
                            <label for="url" class="col-form-label">文件地址</label>
                            <input type="text" class="form-control" name="url" id="url" required>
                        </div>
                        <div class="mb-3">
                            <label for="file" class="col-form-label">文件上传</label>
                            <input type="file" name="file" class="form-control" id="file"
                                   aria-describedby="inputGroupFileAddon04" aria-label="Upload">
                        </div>
                        <div class="modal-footer btn-group-sm">
                            <button type="button" class="btn btn-secondary " data-bs-dismiss="modal">关闭</button>
                            <button type="submit" class="btn btn-primary">确认</button>
                        </div>
                    </form>
                </div>
                <%--                <div class="modal-footer btn-group-sm">--%>
                <%--                    <button type="button" class="btn btn-secondary " data-bs-dismiss="modal">关闭</button>--%>
                <%--                    <button type="submit" class="btn btn-primary">确认</button>--%>
                <%--                </div>--%>
            </div>
        </div>
    </div>


    <div class="modal fade" id="uploadFileModal" tabindex="1" aria-labelledby="uploadFileModal"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="upload">文件上传</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="${pageContext.request.contextPath}/admin/file/upload" method="post"
                          enctype="multipart/form-data">
                        <div class="mb-3">
                            <label for="name" class="col-form-label">文件名</label>
                            <input type="text" class="form-control" name="name"  required>
                        </div>
                        <div class="mb-3">
                            <label for="file" class="col-form-label">文件上传</label>
                            <input type="file" name="file" class="form-control" aria-describedby="inputGroupFileAddon04" aria-label="Upload">
                        </div>
                        <div class="modal-footer btn-group-sm">
                            <button type="button" class="btn btn-secondary " data-bs-dismiss="modal">关闭</button>
                            <button type="submit" class="btn btn-primary">确认</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>



</div>

<script type="text/javascript">
    const exampleModal = document.getElementById('exampleModal')
    exampleModal.addEventListener('show.bs.modal', event => {
        // Button that triggered the modal
        const button = event.relatedTarget
        // Extract info from data-bs-* attributes
        const recipient = button.getAttribute('data-bs-whatever')
        // If necessary, you could initiate an AJAX request here
        // and then do the updating in a callback.
        //
        // Update the modal's content.
        const modalTitle = exampleModal.querySelector('.modal-title')
        const modalBodyInput = exampleModal.querySelector('.modal-body input')

        modalTitle.textContent = `文件上传 ${recipient}`
        modalBodyInput.value = recipient
    })


    const uploadFileModal = document.getElementById('uploadFileModal')
    uploadFileModal.addEventListener('show.bs.modal', event => {
        // Button that triggered the modal
        const button = event.relatedTarget
        // Extract info from data-bs-* attributes
        const recipient = button.getAttribute('data-bs-whatever')
        // If necessary, you could initiate an AJAX request here
        // and then do the updating in a callback.
        //
        // Update the modal's content.
        const modalTitle = uploadFileModal.querySelector('.modal-title')
        const modalBodyInput = uploadFileModal.querySelector('.modal-body input')

        modalTitle.textContent = `文件上传 ${recipient}`
        modalBodyInput.value = recipient
    })


    function deleteFile(id) {
        if (!id) {
            alert("操作失败！获取不到主键信息")
            return
        }
        fetch('${pageContext.request.path}/admin/file/delete/${id}')
            .then(response => response.json())
    }


</script>

</body>
</html>
