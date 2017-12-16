<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>search engine [users-list.jsp]</title>
</head>
<body>


<c:forEach var="entry" items="${list}">
    <c:choose>
        <c:when test="${entry.key.gender.toString()=='MAN'}">
            <c:set var="gender" value="color: blue"/>
        </c:when>
        <c:otherwise>
            <c:set var="gender" value="color: red"/>
        </c:otherwise>
    </c:choose>

    <div style="${gender}">
        ID: <c:out value="${entry.key.id}"/><br/>
        Name: <c:out value="${entry.key.name}"/><br/>
        Surname: <c:out value="${entry.key.surname}"/><br/>
        Login: <c:out value="${entry.key.login}"/><br/>
        Age: <c:out value="${entry.key.age}"/><br/>
        Gender: <c:out value="${entry.key.gender}"/><br/>
        Stats: <c:out value="${entry.value}"/><br/>

    </div>

    <br/><br/>

</c:forEach>

</body>
</html>
