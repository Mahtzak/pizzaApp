<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mae
  Date: 31.01.2019
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja danych szczegółowych</title>
</head>
<body>
    <div>
        <form:form modelAttribute="userDetails" method="post">
            <p>Imię:<br><form:input path="firstName" /><form:errors path="firstName"/></p>
            <p>Nazwisko:<br><form:input path="lastName"/><form:errors path="lastName"/></p>
            <p>Adres zamieszkania:<br><form:input path="address"/><form:errors path="address"/></p>
            <p>Nr telefonu:<br><form:input type="number" path="phoneNumber"/><form:errors path="phoneNumber"/></p>
            <input type="submit" value="Zatwierdź zmiany"/>
            <input type="reset" value="reset"/>
        </form:form>
    </div>
</body>
</html>
