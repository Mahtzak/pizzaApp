<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mae
  Date: 31.01.2019
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dane użytkownika</title>
</head>
<body>
    <form:form modelAttribute="userDetails">
        <p>Imię:</p><br><p><form:input path="firstName"/><form:errors path="firstName"/></p>
        <p>Nazwisko:</p><br><p><form:input path="lastName"/><form:errors path="lastName"/></p>
        <p>Adres:</p><br><p><form:input path="address"/><form:errors path="address"/></p>
        <p>Numer kontaktowy:</p><br><p><form:input path="phoneNumber"/><form:errors path="phoneNumber"/></p>
        <input type="submit" value="Zapisz"/>
    </form:form>
</body>
</html>
