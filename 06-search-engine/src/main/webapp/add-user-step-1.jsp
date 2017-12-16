
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user step 1</title>
</head>
<body>
<div>
    <form method="post" action="add-user-steps">
        <input type="hidden" name="step" value="1"/>
        <label>ID:</label><input name="id" type="text"/><br /><br />
        <label>Login:</label><input name="login" type="text"/><br /><br />

        <input type="submit" name="add-user" value="next"/>
    </form>
</div>
</body>
</html>