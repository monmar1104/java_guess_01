
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user step 1</title>
</head>
<body>
<div>
    <form method="post" action="add-user-steps">
        <input type="hidden" name="step" value="2"/>
        <label>Name:</label><input name="name" type="text"/><br /><br />
        <label>Surname:</label><input name="surname" type="text"/><br /><br />
        <label>Age:</label><input name="age" type="text"/><br /><br />


        <input type="submit" name="add-user" value="next"/>
    </form>
</div>
</body>
</html>