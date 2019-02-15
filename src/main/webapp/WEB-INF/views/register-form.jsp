<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
</head>
<body>
<div>
    <div>
        <form:form modelAttribute="registrationForm" method="post">
            <p>Email: <form:input path="email" type="email" required="true"/><form:errors path="email"/> </p>
            <p>Nazwa użytkownika: <form:input path="username" required="true"/><form:errors path="username"/></p>
            <p>Hasło: <form:password path="password" required="true"/><form:errors path="password"/> </p>
            <p>Powtórz hasło: <form:password path="confirmedPassword" required="true"/><form:errors path="confirmedPassword"/> </p>
                <input type="submit" value="Zarejestruj"/> </p>
        </form:form>
    </div>
</div>
</body>
</html>
