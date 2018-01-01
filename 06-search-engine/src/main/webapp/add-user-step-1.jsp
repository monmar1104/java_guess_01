<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user step 1</title>
</head>
<body>
<div>
    <form method="post" action="add-user-steps">
        <input type="hidden" name="step" value="1"/>
        <label>Login:</label><input name="login" type="text" value="${sessionScope.login}"/><br /><br />

        <input type="submit" name="add-user" value="next"/>
    </form>
    <c:if test="${errorLoginMessage != null}">
        <div style="color: red;">${errorLoginMessage}</div>
    </c:if>
</div>
</body>
</html>