<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mae
  Date: 31.01.2019
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista pracowników</title>
</head>
<body>
    <table>
        <thead>
        <tr>
            <th>Nazwa użytkownika</th>
        </tr>
        </thead>
    </table>
    <c:forEach items="${employees}" var="employee">
         ${employee.username}
    </c:forEach>
</body>
</html>
