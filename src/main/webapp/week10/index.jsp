<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2021/5/10
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>tenth homework</title>
</head>
<body>
<%//set in page , request ,session application
    pageContext.setAttribute("attName","att in page");
    request.setAttribute("attName","att in request");
    session.setAttribute("attName","att in session");
    application.setAttribute("attName","att in application");
%>
<%
    out.println("<br/>"+pageContext.getAttribute("attName"));
    out.println("<br/>"+request.getAttribute("attName"));
    out.println("<br/>"+session.getAttribute("attName"));
    out.println("<br/>"+application.getAttribute("attName"));
%>
<br><hr><h4>Use pageContext to get attribute from page , request , session and application</h4>
<%
    out.println("<br/>"+pageContext.getAttribute("attName",PageContext.PAGE_SCOPE));
    out.println("<br/>"+pageContext.getAttribute("attName",PageContext.REQUEST_SCOPE));
    out.println("<br/>"+pageContext.getAttribute("attName",PageContext.SESSION_SCOPE));
    out.println("<br/>"+pageContext.getAttribute("attName",PageContext.APPLICATION_SCOPE));
%>
<br><hr><h4>Use pageContext to find attribute from page , request , session and application</h4>
<%=pageContext.findAttribute("attName")%>
<!-- search in page , request , session , application , = find first one -->
</body>
</html>
