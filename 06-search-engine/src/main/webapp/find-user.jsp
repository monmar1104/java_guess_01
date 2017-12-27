<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>find user by id or login</title>
</head>
<body>
<h1>Find users by Id or login</h1>
<form method="post" action="find-user-by-id">
    <label>Podaj Id urzytkownika</label>
    <input name="uid" type="text"/><br/>
    <input type="submit" name="find-user-by-id" value="find-user"><br/>
</form>
<form method="post" action="find-user-by-login">
    <label>Podaj login urzytkownika</label>
    <input name="login" type="text"/><br/>
    <input type="submit" name="find-user-by-login" value="find-user"><br/>
</form>
</body>
</html>