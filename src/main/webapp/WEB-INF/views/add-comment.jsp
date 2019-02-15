<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mae
  Date: 01.02.2019
  Time: 09:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <div>
        <form:form modelAttribute="comment" method="post" action="/comment/add">
            <form:textarea rows="10" columns="3" path="text"/><form:errors path="text"/>
            <input type="submit" value="Zamieść"/>
        </form:form>
    </div>

</body>
</html>
