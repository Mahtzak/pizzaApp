<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Zaloguj się</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
</head>
<body>
    <c:if test="${param['error'] != null}">
        <span>Błędne dane logowania</span>
        <c:if test="${message != null}">
            <span>${message}</span>
        </c:if>
    </c:if>
    <form:form modelAttribute="user" method="post">
        <p>Email:<form:input path="email"/><form:errors path="email"/></p>
        <p>Hasło:<form:password path="password"/><form:errors path="password"/></p>
        <input type="submit" value="Wyślij"/>
        <input type="reset" value="Wyczyść"/>
    </form:form>
</body>
</html>
