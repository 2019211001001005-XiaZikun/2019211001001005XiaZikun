<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2021/4/9
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<table>
    <tr>
        <td>Username:</td><td><%=request.getAttribute("username")%></td>
    </tr>
    <tr>
        <td>Password:</td><td><%=request.getAttribute("password")%></td>
    </tr>
    <tr>
        <td>Email:</td><td><%=request.getAttribute("email")%></td>
    </tr>
    <tr>
        <td>Sex:</td><td><%=request.getAttribute("sex")%></td>
    </tr>
    <tr>
        <td>Birthday:</td><td><%=request.getAttribute("birthday")%></td><br>
    </tr>
</table>
<%@include file="footer.jsp"%>
