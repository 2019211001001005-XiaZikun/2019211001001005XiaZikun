<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2021/3/31
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1 style="color: black;font-family: 'Arial Black';font-size: 36px">Login</h1>
<%
    if(request.getAttribute("message")==null){
        //error
        out.println(request.getAttribute("message"));
    }
%>
<form method="post" action="${pageContext.request.contextPath}/login"> <!-- what is method when wo use form?--><!--its GET , why? default is GET,form data is added in the URL,you can see-->
    <!-- its better to use POST in form,data in not added in the URL-->
    UserName: <input type="text" name="username"  style="width: 200px;height: 25px;margin-top: 2px"><br/>
    PassWord: <input type="password" name="password"  style="width: 200px;height: 25px;margin-top: 5px"><br/>
    &nbsp;<input type="submit" value="Login" style="background-color:gray;color: black;width: 75px;height: 25px;text-align: center;font-size: 15px"/>
</form>

<%@include file="footer.jsp"%>

