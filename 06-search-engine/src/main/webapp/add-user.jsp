
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="ISO-8859-1" %>

<html>
<head>
    <title>Add user</title>
</head>
<body>
<div>
    <form method="post" action="add-user">
        <label>Name:</label><input name="name" type="text"/><br /><br />
        <label>Surname:</label><input name="surname" type="text"/><br /><br />
        <label>Login:</label><input name="login" type="text"/><br /><br />
        <label>Age:</label><input name="age" type="text"/><br /><br />
        <label>Gender:</label>
        <select name="gender">
            <option value="">&lt;select&gt;</option>
            <option value="MAN">MAN</option>
            <option value="WOMAN">WOMAN</option>
        </select>
        <input type="submit" name="add-user" value="add-user"/>
    </form>
</div>
</body>
</html>