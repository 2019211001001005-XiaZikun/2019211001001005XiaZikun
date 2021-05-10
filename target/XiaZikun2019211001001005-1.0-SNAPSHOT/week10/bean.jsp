<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2021/5/10
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tenth homework</title>
</head>
<body>
This is JSP page.<br/>
<jsp:useBean id="bean" class="com.XiaZikun.week10.demo.StringBean"/>
<%
    //com.XiaZikun.week10.demo.StringBean bean = new com.XiaZikun.week10.demo.StringBean()
    //bean.setMessage("Hello Mr Bean")
%>
<jsp:setProperty name="bean" property="message" value="<%=request.getParameter("message")%>"/>
<%//=bean.getMessage()%>
<jsp:getProperty name="bean" property="message"/>
</body>
</html>
