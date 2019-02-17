<%--
  Created by IntelliJ IDEA.
  User: Svetlana
  Date: 11.02.2019
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="servlet.CharacterFull" %>
<% CharacterFull chr = (CharacterFull)request.getAttribute("character");%>
<%request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/Main.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Анкета</title>
</head>
<body>
    <img src="${pageContext.request.contextPath}<%=chr.getImg()%>" width="140" height="150"/>
    <div><p class="name"><%=chr.getName()%></p></div>
    <p class="hide member"><%=chr.getMembership()%></p>
    <p class="hide floor"><%=chr.getFloor()%></p>
</body>
</html>
