<%@ page import="com.XiaZikun.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2021/4/9
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
    //get user from session
    User u=(User) session.getAttribute("user");
%>
<table>
    <tr>
        <td>ID:</td><td><%=u.getId()%></td>
    </tr>
    <tr>
        <td>Username:</td><td><%=u.getUsername()%></td>
    </tr>
    <tr>
        <td>Password:</td><td><%=u.getPassword()%></td>
    </tr>
    <tr>
        <td>Email:</td><td><%=u.getEmail()%></td>
    </tr>
    <tr>
        <td>Sex:</td><td><%=u.getSex()%></td>
    </tr>
    <tr>
        <td>Birthday:</td><td><%=u.getBirthday()%></td><br>
    </tr>
    <tr>
        <td><a href="updateUser">Update User</a></td>
    </tr>
</table>
<%@include file="footer.jsp"%>
