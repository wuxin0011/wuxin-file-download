<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        html, body {
            width: 100%;
        }

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            width: 100%;
            height: 100vh;
        }


        form {
            width: 400px;
            height: auto;
            border: 3px solid red;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }

        input {
            padding: 2px 5px;
            width: 80%;
            height: 33px;
        }

        input:focus {
            outline: deepskyblue;
            color: deepskyblue;
        }

    </style>
</head>
<body>

<div class="container">
    <form>
        <input type="text" id="username" name="username" placeholder="username...">
        <br>
        <input type="password" id="password" name="password" placeholder="password...">
        <br>
        <button id="login">登录</button>
    </form>
</div>

<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(function () {

        $('#login').click(function (e) {
            alert('login')
            console.log($('#username').val())
            // 阻止事件冒泡
            login()
            e.stopPropagation()
        })

        function login() {
            let username = $('#username').val()
            let password = $('#password').val()
            let user = {'username': username, 'password': password}
            var u = JSON.stringify(user)
            console.log(u);

            $.ajax({
                method: 'post',
                data: u,
                function(e) {
                    console.log('success' + e)
                },
                error: function (error) {
                    console.log("error", error)
                }
            })


        }


    })
</script>


</body>
</html>