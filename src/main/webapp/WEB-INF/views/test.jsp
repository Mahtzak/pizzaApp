<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Mae
  Date: 29.01.2019
  Time: 09:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>testowa</title>
</head>
<body>
    <div>
        <%--poniższe widoczne tylko dla zalogowanego użytkownika--%>
        <sec:authorize access="isAuthenticated()">
            Cześć, ${user}
        </sec:authorize>
        <sec:authorize access="hasRole('ADMIN')">
            Wiadomość dostępna tylko dla użytkowników z rolą admin
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
            <a href="/login">Zaloguj</a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <a href="/logout">Wyloguj</a>
        </sec:authorize>
    </div>
</body>
</html>
