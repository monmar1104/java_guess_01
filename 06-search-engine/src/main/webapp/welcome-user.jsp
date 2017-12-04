
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div>
    <h2> Witaj ${name}, salary ${salary} </h2>


    <c:set var="bonus" scope="request" value="${salary*1.2}"/>
    <c:out value="${bonus}" default="0,00" />
    <h2> Witaj ${sessionScope.sessionName}, salary ${sessionScope.sessionSallary} </h2>
</div>