<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>User details</title>
</head>
<body>
<h1>User details</h1>

<c:if test="${errorMessage != null}">
    <div style="color: red;">${errorMessage}</div>
</c:if>
<c:if test="${okMessage != null}">
    <div style="color: green;">${okMessage}</div>
</c:if>
<br/><br/>
<div>
      ID: <c:out value="${sessionScope.userId}"/><br/>
      Name: <c:out value="${sessionScope.name}"/><br/>
      Surname: <c:out value="${sessionScope.surname}"/><br/>
      Login: <c:out value="${sessionScope.login}"/><br/>
      Age: <c:out value="${sessionScope.age}"/><br/>
      Gender: <c:out value="${sessionScope.gender}"/><br/>
    <c:if test="${stats!=null}">
      Stats: <c:out value="${stats}"/><br/>
    </c:if>
  </div>
  <br/><br/>
<c:if test="${isUpdateUser == false}">
  <form method="post" action="update-user">
      <input type="submit" name="update-user" value="update-user">
  </form>
</c:if>
<%@ include file="go-back.jsp" %>
</body>
</html>
