<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2021/5/10
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    if("admin".equals(password)){
%>
<jsp:forward page="welcome.jsp"></jsp:forward>
<%
    }else{
        out.write("Username Password Error!!!");
%>
<jsp:include page="login.jsp"></jsp:include>
<%
    }
%>
</body>
</html>
