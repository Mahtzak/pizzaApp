<%--
  Created by IntelliJ IDEA.
  User: Mae
  Date: 31.01.2019
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Błąd</title>
</head>
<body>
    <h3>Pojawił się błąd</h3>
    <p>Być może próbowano się dostać na stronę do oglądania której nie masz
    uprawnień...</p>

    <form action="/">
        <input type="submit" value="Wróć na stronę główną"/>
    </form>

<form action="/logout">
    <input type="submit" value="Zaloguj się na inne konto"/>
</form>
</body>
</html>
