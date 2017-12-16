
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user step 1</title>
</head>
<body>
<div>
    <form method="post" action="add-user-steps">
        <input type="hidden" name="step" value="3"/>
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