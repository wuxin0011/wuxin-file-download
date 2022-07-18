<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>通知管理</title>
    <jsp:include page="../common/headFile.jsp"/>

    <style>
        .card-text {
            font-size: 16px;
        }
    </style>
</head>
<body>

<div class="container col-xl-6 col-sm-12 col-xs-12 col-xxl-4 px-10 py-10 mt-5">
    <jsp:include page="../common/admin/header.jsp"/>


    <section>

        <div class="message mt-4">
            <div class="card mt-4">
                <h5 class="card-header">2022年7月16日07:00:49</h5>
                <div class="card-body">
                    <p class="card-text">可以上传一些内容好看的东西嘛？xxxxxxx</p>
                    <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal"
                            data-bs-target="#exampleModal" data-bs-whatever="@mdo">修改
                    </button>
                    <button class="btn btn-danger btn-sm">删除</button>
                </div>
            </div>

            <div class="card mt-4">
                <h5 class="card-header">2022年7月16日07:00:49</h5>
                <div class="card-body">
                    <p class="card-text">xxxxxx可以上传一些内容好看的东西嘛？</p>
                    <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal"
                            data-bs-target="#exampleModal" data-bs-whatever="@mdo">修改
                    </button>
                    <button class="btn btn-danger btn-sm">删除</button>
                </div>
            </div>

        </div>


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
