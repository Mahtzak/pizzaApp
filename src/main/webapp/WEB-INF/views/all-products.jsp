<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mae
  Date: 31.01.2019
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista wszystkich pozycji z menu</title>
</head>
<body>
    <table>
        <thead>
        <tr>
            <th>Nazwa</th>
            <th>Opis</th>
            <th>Cena</th>
            <th>Typ</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product" >
            <tr>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>${product.type}</td>
                <td><a href="/admin/product/edit/${product.id}">Zmień produkt</a></td>
                <td><a href="/admin/product/delete/${product.id}">Usuń produkt</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>
