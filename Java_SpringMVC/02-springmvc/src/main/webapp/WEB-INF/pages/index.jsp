<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>主页</title>
    <jsp:include page="common/headFile.jsp"/>
    <style>
        li {
            list-style: none;
        }

        main a::before {
            content: ' 📂 ';
        }

        main a:hover {
            text-decoration: underline !important;
        }
    </style>
</head>


<body>

<div class="container col-xl-6 col-sm-12 col-xs-12 col-xxl-4 px-10 py-10 mt-5">
    <%@ include file="./common/header.jsp" %>
    <main class="col-12">
        <ul id="categoryList"></ul>
        <div class="dropdown-divider"></div>
    </main>
    <%@ include file="./common/footer.jsp" %>
</div>

<script>
    $(function () {
        $.ajax({
            url: '/category/list',
            type: 'GET',
            async: false,
            dataType: 'json',
            success: function (res) {
                const categoryListDOM = $("#categoryList")
                if (res.code === 200) {
                    if (res.data.length !== 0) {
                        res.data.forEach(item => {
                            const {name, cid} = item
                            const li = '<li class="mt-1 mb-1">' + '<a href="/category/' + cid + '" class=" link-dark text-decoration-none text-success">' + name + '</a>' + '</li>'
                            categoryListDOM.append(li)
                        })
                    } else {
                        $("main").append('<h3 class="text-dark">暂无 内容！<h3>')
                    }
                } else {
                    $("main").append('<h3 class="text-danger">加载失败！<h3>')
                }

            },
            error: function (e) {

            }
        })


    })

</script>

</body>

</html>