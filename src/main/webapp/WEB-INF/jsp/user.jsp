<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 联想辉哥
  Date: 2019/4/22
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
    <link rel="stylesheet" href="http://code.jquery.com/mobile/[version]/jquery.mobile-[version].min.css" />
    <script src="http://code.jquery.com/jquery-[version].min.js"></script>
    <script src="http://code.jquery.com/mobile/[version]/jquery.mobile-[version].min.js"></script>

</head>
<body>

<form action="${pageContext.request.contextPath}/" method="post">
    <input type="hidden" name="openid" value="${openid}">
    <input type="hidden" name="sex" value="${sex}">

    <div>
        <label for="tel">微信用户:</label>
        <input type="tel" name="nickname" id="nickname" value="${nickname}">
    </div>
    <br>
    <div>
        <label for="tel">Tel:</label>
        <input type="tel" name="tel" id="tel">
    </div>
    <br>
    <div>
        <label for="password">Password:</label>
        <input type="password" name="password" id="password"  autocomplete="off">
    </div>
    <br>
    <button class="ui-btn ui-btn-inline">绑定</button>
</form>

</body>
</html>
