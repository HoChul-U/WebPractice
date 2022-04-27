<%@ page contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang=\"en\">
<head>
    <meta charset=\"UTF-8\">
    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">
    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\\\">
    <title>Document</title>
    </head>
    <body>
    <form action="/cart" method="post">
    <input type ="number" name="onion"/>"Onion"<br>
    <input type="number" name="eggs"/>"Egg"<br>
    <input type="number" name="welshOnion"/>"WelshOnion"<br>
    <input type="number" name="apple"/>"Apple"<br>
    <button type="submit">Go_list</button>
    </form>
    </body>
</html>
<c:forEach var="food" items="${foodList}">
    수량 : <li>${food.foodCount()}</li><br>
    품몫 : <li>${food.foodName()}</li><br>
    가격 : <li>${food.foodMoney()}</li><br>
</c:forEach>