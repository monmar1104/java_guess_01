<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <c:choose>
            <c:when test="${sessionScope.gender == 'MAN'}">
            <select name="gender">
                <option selected>MAN</option>
                <option>WOMAN</option>
            </select>
            </c:when>
            <c:when test="${sessionScope.gender == 'WOMAN'}">
                <select name="gender">
                    <option value="MAN">MAN</option>
                    <option selected value="WOMAN">WOMAN </option>
                </select>
            </c:when>
            <c:otherwise>
                <select name="gender">
                    <option value="select gender">&lt;select&gt;</option>
                    <option value="MAN">MAN</option>
                    <option value="WOMAN">WOMAN</option>
                </select>
            </c:otherwise>
        </c:choose>
        <input type="submit" name="submit" value="submit"/>
    </form>
</div>
</body>
</html>