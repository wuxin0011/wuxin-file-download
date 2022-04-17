<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }


        html, body {
            position: relative;
            width: 100%;
        }

        .container {
            width: 100%;
            height: 100vh;
            position: relative;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container > form {
            width: 400px;
            height: auto;
            border-radius: 10px;
            border: 10px solid deepskyblue;
            padding: 20px;
            box-shadow: 1px 1px 4px rgba(0, 0, 0, 1);
            animation: borderColor 5s linear 3s infinite;
        }

        @keyframes borderColor {

            0% {
                border: 10px solid palegoldenrod;
            }
            20% {
                border: 10px solid olive;
            }
            40% {
                border: 10px solid olivedrab;
            }
            50% {
                border: 10px solid orange;
            }
            60% {
                border: 10px solid darkcyan;
            }
            80% {
                border: 10px solid teal;
            }
            100% {
                border: 10px solid palegoldenrod;
            }

        }

        .item {
            margin: 30px auto;
            text-align: center;
            display: flex;
            justify-content: space-around;
        }

        .item > label {
            font-size: 14px;
        }

        .item > input {
            flex: 2;
            outline-color: deepskyblue;
            border: 1px solid skyblue;
            margin-left: 10px;
            height: 22px;
            padding: 4px;
        }

        .item > label {
            vertical-align: middle;
        }

        .item > button {
            flex: 1;
            margin: auto 2px;
            height: 34px;
            padding: 10px;
            background: linear-gradient(145deg, #e66465, #daaeae, #9198e5);
        }
    </style>

</head>
<body>
<div class="container">
    <form>
        <div class="item">
            <h2>登录</h2>
        </div>
        <div class="item">
            <label for="username">username:</label>
            <input type="text" placeholder="username..." name="username" id="username">
        </div>
        <div class="item">
            <label for="password">password:</label>
            <input type="text" placeholder="password..." name="password" id="password">
        </div>
        <div class="item">
            <button id="login">Login</button>
            <button id="reset">Reset</button>
        </div>
    </form>
</div>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(function () {
        $('#login').click(function (e) {
            let user = JSON.stringify({'username': $('#username').val(), 'password': $('#password').val()})
            $.ajax({
                url: 'login',
                type: 'post',
                data: user,
                dataType: 'json',
                contentType: "application/json;charset=UTF-8",
                success: function (data) {
                    console.log(data)
                    alert('登录成功！')
                },
                error: function (err) {
                    console.log(err)
                },
            })
            e.stopPropagation()
        })
    })
</script>

</body>
</html>