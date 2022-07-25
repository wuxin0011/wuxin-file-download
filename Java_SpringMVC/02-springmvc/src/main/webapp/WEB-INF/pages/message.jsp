<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8">
    <title>留言板</title>
    <jsp:include page="common/headFile.jsp"/>
    <style>

        a {
            text-decoration: none;
            color: #34383C !important;
        }

        a[href^='email']::before {
            content: ' ✉ ';
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>
<div class="container col-xl-6 col-sm-12 col-xs-12 col-xxl-4 px-10 py-10 mt-5">
    <%@ include file="./common/header.jsp" %>


    <div class="mb-2 mt-2">
        <span>您可以通过邮箱联系我</span><a href="email:+2191377759@qq.com">2191377759@qq.com</a>
        <span>或者通过留言板</span>
    </div>

    <div id="messageForm">
        <div class="mb-2 mt-4">
            <label for="email" class="form-label">邮箱</label>
            <input type="email" class="form-control" name="email" id="email" required>

        </div>
        <div class="mb-3">
            <label for="contentText" class="form-label">留言内容</label>
            <textarea class="form-control" id="contentText" rows="3" name="content" required minlength="2"
                      maxlength="500"></textarea>


        </div>
        <div class="mb-3">
            <a class="btn btn-outline-primary btn-sm" href="javascript:history.go(-1)">返回</a>
            <button class="btn btn-primary btn-sm " type="submit" id="submitBtn">提交</button>
        </div>
    </div>
    <%@ include file="./common/footer.jsp" %>

</div>


<script type=text/javascript>
    $(function () {


        $("#submitBtn").click(function (e) {
            const content = $("#contentText").val()
            const email = $("#email").val()

            if (!email) {
                alert("邮箱未填写！")
                return;
            }
            if (!content) {
                alert("请填写内容")
                return
            }

            $.ajax({
                url: '/message/add',
                async: false,
                type: 'post',
                dataType: 'json',
                data: {content, email},
                success: function (res) {
                    if (res.code === 200) {
                        $("#contentText").val('')
                        $("#email").val('')
                    }
                    alert(res.message)
                },
                error: function (e) {
                    alert("提交失败！未知错误！")
                }
            })


        })

    })
</script>

</body>

</html>