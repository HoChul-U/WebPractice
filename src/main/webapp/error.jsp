<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Error</title>
</head>
<body>
<h1>Error Page</h1><br>
<br>
Error Type: <%= exception.getClass().getName() %>> <br>
Error Message <%= exception.getMessage()%> <br>
</body>
</html>