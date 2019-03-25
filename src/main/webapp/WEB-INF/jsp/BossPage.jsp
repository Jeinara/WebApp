<%@ page import="webProject.bean.BossExtra" %>
<%--
  Created by IntelliJ IDEA.
  User: Svetlana
  Date: 11.02.2019
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<% BossExtra chr = (BossExtra) request.getAttribute("character");%>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/Main.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Анкета</title>
</head>
<body>
<table border=1>
    <tr>
        <td rowspan=5> <img src="${pageContext.request.contextPath}<%=chr.getImg()%>" width="140" height="150"/> </td>
        <td colspan="2"> <p class="name"><%=chr.getName()%></p> </td>
    </tr>
    <tr>
        <td>Возраст: <%=chr.getAge()%></td>
        <td>Должность: <%=chr.getPost()%></td>
    </tr>
    <tr>
        <td colspan="2" >Пол: <%=chr.getSex()%></td>
    </tr>
    <tr>
        <td> <p class="floor">Этаж: <%=chr.getFloor()%></p> </td>
        <td> <p class="member">Группировка: <%=chr.getMembership()%></p></td>
    </tr>
    <tr>
        <td colspan="2">Грех: <%=chr.getSin()%></td>
    </tr>
    <tr>
        <td colspan="3"><p><%=chr.getNature()%></p></td>
    </tr>
    <tr>
        <td colspan="3"><p><%=chr.getSocial()%></p></td>
    </tr>
    <tr>
        <td colspan="3"><p><%=chr.getCharacter()%></p></td>
    </tr>
    <tr>
        <td colspan="3"><p><%=chr.getPortrait()%></p></td>
    </tr>
    <tr>
        <td colspan="3"><p><%=chr.getSkills()%></p></td>
    </tr>
    <tr>
        <td colspan="3"><p><%=chr.getBio()%></p></td>
    </tr>
    <tr>
        <td colspan="3"><p><%=chr.getPhobias()%></p></td>
    </tr>
    <tr>
        <td colspan="3"><p><%=chr.getDie()%></p></td>
    </tr>
    <tr>
        <td colspan="3"><p><%=chr.getGoal()%></p></td>
    </tr>
</table>
</body>
</html>
