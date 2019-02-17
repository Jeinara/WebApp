<%@ page import="java.util.ArrayList" %>
<%@ page import="servlet.Character" %><%--
  Created by IntelliJ IDEA.
  User: Svetlana
  Date: 13.11.2018
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%request.setCharacterEncoding("UTF-8");%>
<% ArrayList<Character> list = (ArrayList<Character>)request.getAttribute("list");%>
<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/Main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/SearchForm.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Папка Ключника</title>
</head>
<body>
<div class="tool-bar">
    <p></p>
</div>
<div class="search-box">
    <p>Ищешь кого-то? Спроси</p>
    <div class="search-note"><input type="text" spellcheck="false" oninput="search(this)"/></div>
</div>
<div class="content">
    <div class="menu">
        <p style="display: none">Поисковые фильтры</p>
        <ul>
            <li class="sort first" data-sort-tag="sort_by_al" onclick="font_change(this);sorting(this)">По алфавиту</li>
            <li class="sort" data-sort-tag="sort_by_floor" onclick="font_change(this);sorting(this)">По этажу</li>
            <li class="sort" data-sort-tag="sort_by_group" onclick="font_change(this);sorting(this)">По группировке</li>
        </ul>
    </div>
    <div class="table">
        <ul class="decoration_first"></ul>
        <%  int j1 = 0;
            for (Character chr: list) {
                if(j1==0){%>
        <ul class="card_set">
                        <%}%>
            <li class="card" onclick="location.href='/home13/Character?name=<%=chr.getName()%>'">
                <img src="${pageContext.request.contextPath}<%=chr.getImg()%>" width="140" height="150"/>
                <div><p class="name"><%=chr.getName()%></p></div>
                <p class="hide member"><%=chr.getMembership()%></p>
                <p class="hide floor"><%=chr.getFloor()%></p></li><%
            j1++;
            if(j1==3){
                j1=0;%>
        </ul><%
                }
            }
            if(j1!=3){%>
        </ul><%}%>
        <ul class="decoration_last"></ul>
        <!--Получить количество. Поделить его нацело на три.
        Собрать получившееся количество строк(всегда должна быть минимум одна)
        Сделать макет карточки -->
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>
