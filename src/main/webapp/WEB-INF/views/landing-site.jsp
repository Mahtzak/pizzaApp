<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Mae
  Date: 29.01.2019
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona główna</title>
</head>
<body>
    <sec:authorize access="isAnonymous()">
    <a href="/register">Zarejestruj się</a>
   <a href="/login">Zaloguj się</a>
    </sec:authorize>

    <sec:authorize access="hasRole('ADMIN')">
        <a href="/admin">Panel administracyjny</a>
    </sec:authorize>
    <a href="/details">Dane kontaktowe</a>
    <a href="/comment/add">Dodaj komentarz</a>

    <div>
        <c:forEach items="${allComments}" var="comment">
            <h6>Data utworzenie: ${comment.created}  @${comment.user.username}</h6>
            ${comment.text}
        </c:forEach>
    </div>
</body>
</html>
