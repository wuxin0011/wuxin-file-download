<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>通知管理</title>
    <jsp:include page="../common/headFile.jsp"/>
</head>
<body>

<div class="container col-xl-6 col-sm-12 col-xs-12 col-xxl-4 px-10 py-10 mt-5">
    <jsp:include page="../common/admin/header.jsp"/>


    <section>

        <button type="button" class="btn btn-primary btn-sm col-2" data-bs-target="#noticeModal" data-bs-toggle="modal"
                data-bs-type="add">添加
        </button>

        <div class="message mt-4">
            <c:choose>
                <c:when test="${requestScope.notices.size()!=0}">
                    <c:forEach var="notice" items="${requestScope.notices}">
                        <div class="card mt-4">
                            <h5 class="card-header">
                                #&nbsp;<span class="fs-6"><fmt:formatDate pattern="yyyy-MM-dd"
                                                                          value="${notice.createTime}"/></span>
                                <span class="link-dark fs-6">${notice.title}</span>
                            </h5>

                            <div class="card-body fs-6">
                                <p class="card-text fs-6">${notice.content}</p>
                            </div>
                            <div class="card-footer">
                                <button
                                        type="button"
                                        class="btn btn-primary btn-sm"
                                        data-bs-target="#noticeModal"
                                        data-bs-toggle="modal"
                                        data-bs-type="update"
                                        data-bs-id="${notice.nid}"
                                        data-bs-title="${notice.title}"
                                        data-bs-content="${notice.content}"
                                >
                                    修改
                                </button>
                                <button class="btn btn-danger btn-sm" onclick="deleteNotice(${notice.nid})">删除</button>
                            </div>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <h4 class="text-dark"> 暂无内容</h4>
                </c:otherwise>

            </c:choose>
        </div>
    </section>


    <div class="modal fade" id="noticeModal" tabindex="-1" aria-labelledby="noticeModal"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modal-title">发布公告</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                            aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="notice-title" class="col-form-label">标题</label>
                        <input type="text" name="title" class="form-control" id="notice-title" required>
                    </div>
                    <div class="mb-3">
                        <label for="notice-content" class="col-form-label">内容:</label>
                        <textarea class="form-control" id="notice-content" name="content"></textarea>
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
        const modalInputTitle = noticeModal.querySelector('#notice-title')
        const modalInputContent = noticeModal.querySelector('#notice-content')
        const modalTitle = noticeModal.querySelector('#modal-title')


        const varTtitle = eventType === 'update' ? '修改' : '添加'

        // 重置
        modalInputTitle.value = ''
        modalInputContent.value = ''
        var nid;
        // 判断事件类型
        if (eventType === 'update') {
            nid = button.getAttribute('data-bs-id')
            const noticeTitle = button.getAttribute('data-bs-title')
            const noticeContent = button.getAttribute('data-bs-content')


            modalInputTitle.value = noticeTitle
            modalInputContent.value = noticeContent
        }

        modalTitle.textContent = varTtitle + '公告'


        document.querySelector("#submitNoticeBtn").addEventListener('click', () => {

            var title = modalInputTitle.value.trim();
            var content = modalInputContent.value.trim();
            if (title.length === 0) {
                alert("请填写标题")
                return
            }
            if (content.length === 0) {
                alert("请填写内容")
                return
            }

            if (!confirm('确认' + varTtitle)) {
                return;
            }


            if (eventType === 'update') {
                update(nid, title, content)
            } else {
                add(title, content)
            }

        })


    })


    function add(title, content) {
        $.ajax({
            url: '/admin/notice/add',
            type: 'post',
            dataType: 'json',
            data: {'title': title, 'content': content},
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

    function update(nid, title, content) {
        var dataJSON = JSON.stringify({'nid': nid, 'title': title, 'content': content})
        $.ajax({
            url: '/admin/notice/update',
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

            },

        })

    }


    function deleteNotice(nid) {
        if (!confirm('确认删除？该操作不可回复！')) {
            return;
        }
        $.ajax({
            url: '/admin/notice/delete/' + nid,
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
