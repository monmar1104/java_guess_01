<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="ISO-8859-1" %>

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
      ID: <c:out value="${userId}"/><br/>
      Name: <c:out value="${name}"/><br/>
      Surname: <c:out value="${surname}"/><br/>
      Login: <c:out value="${login}"/><br/>
      Age: <c:out value="${age}"/><br/>
      Gender: <c:out value="${gender}"/><br/>
    <c:if test="${stats}!=null">
      Stats: <c:out value="${stats}"/><br/>
    </c:if>
  </div>
  <br/><br/>
  <form method="post" action="update-user">
      <input type="submit" name="update-user" value="update-user">
  </form>
<%@ include file="go-back.jsp" %>
</body>
</html>
