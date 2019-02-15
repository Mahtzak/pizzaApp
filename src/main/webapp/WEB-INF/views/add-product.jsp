<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mae
  Date: 31.01.2019
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodawanie produktu</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
          crossorigin="anonymous">

</head>
<body>
        <div>
        <form:form modelAttribute="product" method="post">
            Nazwa produktu:<br><form:input path="name"/><form:errors path="name"/><br>
            Opis produktu:<br><form:textarea path="description" /><form:errors path="description"/><br>
            Cena:<br><form:input type="number" path="price"/><form:errors path="price"/><br>
            Typ:<br><form:input type="number" path="type" /><form:errors path="type"/><br>
            <input type="submit" value="Dodaj"/>
        </form:form>
        </div>
</body>
</html>
