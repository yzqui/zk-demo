<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yuzhq
  Date: 2020/8/7
  Time: 6:05 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
	<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.3.js"></script>
</head>
<body>
<h1>配置</h1>
<c:forEach items="${config}" var="item">
key：
<input type="text" disabled value="${item.key}" class="key${item.key}">
value：
<input type="text" disabled value="${item.value}" class="val${item.key}">
<p>
	</c:forEach>
</body>
</html>
