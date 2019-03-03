<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Hello JSP</title>
</head>
<body>

    <h1>Strona główna</h1>

    <c:if test="${ empty sessionScope.user }">
        <section>
            <form action="/login" method="post">
                <input type="text" name="login">
                <input type="password" name="password">
                <input type="submit" value="Loguj">
            </form>
        </section>
    </c:if>
    <c:if test="${ not (empty sessionScope.user) }">
        <a href="/logout">Wyloguj</a>
    </c:if>


    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium amet animi aspernatur aut autem blanditiis culpa cum cupiditate, distinctio dolorem dolores ea eos et ex facilis fuga fugiat harum illum impedit incidunt laboriosam, libero nobis nulla quam qui quo ratione rem repellendus reprehenderit rerum saepe sed sequi unde ut voluptate?</p>


</body>
</html>