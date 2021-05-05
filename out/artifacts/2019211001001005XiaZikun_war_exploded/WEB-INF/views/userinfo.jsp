<%@ page import="com.XiaZikun.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2021/4/9
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
    User user=(User) request.getAttribute("user");
%>
<table>
    <tr>
        <td>Username:</td><td><%=user.getUsername()%></td>
    </tr>
    <tr>
        <td>Password:</td><td><%=user.getPassword()%></td>
    </tr>
    <tr>
        <td>Email:</td><td><%=user.getEmail()%></td>
    </tr>
    <tr>
        <td>Sex:</td><td><%=user.getSex()%></td>
    </tr>
    <tr>
        <td>Birthday:</td><td><%=user.getBirthday()%></td><br>
    </tr>
</table>
<%@include file="footer.jsp"%>
