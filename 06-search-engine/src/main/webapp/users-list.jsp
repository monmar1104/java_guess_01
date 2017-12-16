<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users list</title>
</head>
<body>
<c:forEach var="list" items="${userslist}">
    <c:choose>
        <c:when test="${list.gender.toString()=='MAN'}">
            <c:set var="gender" value="color: blue"/>
        </c:when>
        <c:otherwise>
            <c:set var="gender" value="color: red"/>
        </c:otherwise>
    </c:choose>
    <div style="${gender}">
    Id <c:out value="${list.id}"/><br/>
    Name <c:out value="${list.name}"/><br/>
    Surname <c:out value="${list.surname}"/><br/>
    Login <c:out value="${list.login}"/><br/>
    Age <c:out value="${list.age}"/><br/>
    Gender <c:out value="${list.gender}"/><br/>
    <br/>
</div>
</c:forEach>

</body>
</html>
