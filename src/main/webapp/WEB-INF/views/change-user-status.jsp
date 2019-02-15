<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mae
  Date: 01.02.2019
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zmiana statusu użytkownika</title>
</head>
<body>
<div>
    <table>
        <thead>
        <tr>
            <th>Nazwa użytkownika</th>
            <th>Rola użytkownika</th>
        </tr>
        </thead>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.user.username}</td>
            <td>${user.role}</td>
            <td><a href="admin/addEmployee"</td>
        </tr>
    </c:forEach>
    </table>
</div>
</body>
</html>
