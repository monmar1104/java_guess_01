<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user step 1</title>
</head>
<body>
<div>
    <form method="post" action="add-user-steps">
        <input type="hidden" name="step" value="2"/>
        <label>Name:</label><input name="name" type="text" value="${sessionScope.name}"/><br /><br />
        <c:if test="${errorNameMessage != null}">
            <div style="color: red;">${errorNameMessage}</div>
        </c:if>
        <label>Surname:</label><input name="surname" type="text" value="${sessionScope.surname}" /><br /><br />
        <c:if test="${errorSurnameMessage != null}">
            <div style="color: red;">${errorSurnameMessage}</div>
        </c:if>
        <label>Age:</label><input name="age" type="text" value="${sessionScope.age}"/><br /><br />
        <c:if test="${errorNumberMessage != null}">
            <div style="color: red;">${errorNumberMessage}</div>
        </c:if>


        <input type="submit" name="add-user" value="next"/>
    </form>
</div>
</body>
</html>