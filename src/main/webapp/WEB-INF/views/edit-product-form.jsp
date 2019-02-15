<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mae
  Date: 31.01.2019
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edycja produktu</title>
</head>
<body>
<form:form modelAttribute="product" method="post" action="/admin/product/edit">
    <form:hidden path="id"/>
    <p>Nazwa:<br><form:input path="name"/><form:errors path="name"/></p>
    <p>Opis:<br><form:textarea path="description"/><form:errors path="description"/></p>
    <p>Cena:<br><form:input type="number" step="0.01" path="price"/><form:errors path="price"/></p>
    <p>Typ:<br><form:input type="number" path="type"/><form:errors path="type"/></p>
    <input type="submit" value="Zatwierdź"/>
</form:form>
</body>
</html>
