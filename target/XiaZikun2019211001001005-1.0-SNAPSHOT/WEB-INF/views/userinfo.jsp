<%@ page import="com.XiaZikun.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2021/4/9
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>

<%
    //get user from session
    User u=(User) session.getAttribute("user");
    if(u.getUsername().equals("admin")){
%>
<h1 style="font-family: 'Arial Black';font-size: 30px"><%= "Welcome Administrator"%></h1>
<br> <a href="userlist.jsp">User List</a>
<br> <a href="#">Product List</a>
<%}else{%>
<h1>User Info</h1>
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
<%}//end%>
<%@include file="footer.jsp"%>
