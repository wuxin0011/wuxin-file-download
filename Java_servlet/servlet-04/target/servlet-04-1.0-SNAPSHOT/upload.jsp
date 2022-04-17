<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
<h2 style="color: skyblue">servlet实现 文件上传测试</h2>
<input type="file" placeholder="文件上传测试" id="file" name="file">
<button id="submit">submit</button>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(function () {
        // do
        $('#submit').click(function () {
            $.ajax({
                url: '/upload/file',
                type: 'post',
                data: {'file': $('#file').val()},
                dataType: "multipart/form-data",
                success: function (data) {
                    alert(JSON.stringify(err))
                },
                error: function (err) {
                    confirm(JSON.stringify(err))
                },
            })
        })
    })
</script>

</body>
</html>
