<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mae
  Date: 31.01.2019
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usuwanie</title>
</head>
<body>
    Czy jesteś pewien, że chcesz usunąć produkt ${product.name}?<br>
    <form:form modelAttribute="product" action="/admin/product/delete">
        <form:hidden path="id"/>
        <input type="submit" value="TAK"/>
    </form:form>

</body>
</html>
