<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Marian
  Date: 29.07.2019
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/style.css"/>" type="text/css">
    <title>Error</title>
    <jsp:include page="menu.jsp"/>
</head>
<body>
<div style="text-align: center" >
    <h1 >Input data is not correct, please try again</h1>
    <img src="${pageContext.request.contextPath}/resources/homer_doh.png">
</div>
</body>
</html>
