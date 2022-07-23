<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    header ul a:hover {
        text-decoration: underline !important;
    }

    header  ul a:active{
        color: teal;
        text-decoration: underline !important;
    }
</style>
<body>

<header
        class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
    <ul class="nav col-7 col-md-auto mb-2 justify-content-center mb-md-0 fs-5">
        <li><a href="/" class="link-dark px-2 text-decoration-none">首页</a></li>
        <li><a href="/admin/main" class="link-dark px-2  text-decoration-none">管理</a></li>
        <li><a href="/admin/file" class="link-dark px-2  text-decoration-none">文件</a></li>
        <li><a href="/admin/category" class="link-dark px-2  text-decoration-none">分类</a></li>
        <li><a href="/admin/user" class="link-dark px-2 link-dark text-decoration-none">用户</a></li>
        <li><a href="/admin/notice" class="link-dark px-2 link-dark text-decoration-none">通知</a></li>
    </ul>

    <div class="col-5  fs-5">
        <a href="/admin/user/personal"
           class=" px-2 link-dark text-decoration-underline ">${sessionScope.loginUser.username}</a>
        <a href="#" class="link-dark px-2 link-dark text-decoration-none" id="logout">退出</a>
    </div>

    <script type="text/javascript">

        document.querySelector('#logout').addEventListener('click', (e) => {
            e.preventDefault()
            if (confirm('确认退出？')) {
                $.ajax({
                        url: '/admin/user/logout',
                        type: 'get',
                        dataType: 'json',
                        success: function (result) {
                            if (result.code === 200) {
                                setTimeout(() => {
                                    window.location.href = '/login'
                                }, 1000)
                            }
                        }
                    }
                )

            }
        })


    </script>

</header>
</body>

</html>