<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>配置</title>
	<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.3.js"></script>
	<script type="text/javascript">
        $(document).ready(function () {
            $(".edit").click(function () {
                var configName = $(".key" + this.name).val();
                var configValue = $(".val" + this.name).val();
                var url = "http://localhost:8081/edit?configName=" + configName + "&configValue=" + configValue;
                $.get(url, function (data) {
                    alert("修改成功")
                    window.location.reload()
                })
            });
            $(".delete").click(function () {
                var url = "http://localhost:8081/delete?configName=" + this.name;
                $.get(url, function (data) {
                    alert("删除成功")
                    window.location.reload()
                })
            });
            $(".create").click(function () {
                var configName = $(".newKey").val()
                var configValue = $(".newVal").val()
                var url = "http://localhost:8081/create?configName=" + configName + "&configValue=" + configValue;
                $.get(url, function (data) {
                    alert("添加成功")
                    window.location.reload()
                })
            })

        });

	</script>
</head>
<body>
<h1>添加配置</h1>
key：
<input type="text" class="newKey">
value：
<input type="text" class="newVal">
<input type="button" class="create" value="添加"/>
<h1>配置</h1>
<c:forEach items="${config}" var="item">
key：
<input type="text" disabled value="${item.key}" class="key${item.key}">
value：
<input type="text" value="${item.value}" class="val${item.key}">
<input name="${item.key}" type="button" class="edit" value="修改"/>
<input name="${item.key}" type="button" class="delete" value="删除"/>
<p>
	</c:forEach>
</body>
</html>
