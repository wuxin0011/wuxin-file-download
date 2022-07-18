<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <form class="form-inline">
                <input class="form-control mr-sm-2 w-100" type="search" placeholder="Search"
                       aria-label="Search">
                <!-- 							<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button> -->
            </form>
        </div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">名称</th>
                <th scope="col">地址</th>
                <th scope="col">分类</th>
                <th scope="col">日期</th>
                <th scope="col">操作</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row" class="col-1 content">2</th>
                <td class="col-1 content">Jacob</td>
                <td class="col-2 content">
                    <a href="javascript:void(0)"></a>
                </td>
                <td class="col-1 content">
                    <label class="btn btn-success btn-sm">vue</label>
                </td>
                <td class="col-2 content">2022-7-1</td>
                <td class="col-4">
                    <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal"
                            data-bs-target="#exampleModal" data-bs-whatever="@mdo">编辑
                    </button>
                    <button class="btn btn-dark btn-sm">禁用</button>
                    <button class="btn btn-danger btn-sm">删除</button>
                </td>
            </tr>
            </tbody>
        </table>
    </div>


    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">New message</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
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

        modalTitle.textContent = `New message to ${recipient}`
        modalBodyInput.value = recipient
    })
</script>

</body>
</html>
