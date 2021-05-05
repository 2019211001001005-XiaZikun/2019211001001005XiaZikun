<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2021/4/23
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1>User Update</h1>
<!--need form-->
<%
    //get user from session
    User u=(User) session.getAttribute("user");
%>
<form method="post" action="/updateUser"> <!-- what is method when wo use form?--><!--its GET , why? default is GET,form data is added in the URL,you can see-->
    <!-- its better to use POST in form,data in not added in the URL-->
    <input TYPE="hidden" name="id" value="<%=u.getId()%>">
    UserName <input type="text" name="Username" value="<%=u.getUsername()%>" style="width: 200px;height: 25px;margin-top: 2px"><br/>
    PassWord <input type="password" name="password" value="<%=u.getPassword()%>" style="width: 200px;height: 25px;margin-top: 5px"><br/>
    Email <input type="text" name="Email" value="<%=u.getEmail()%>" style="width: 200px;height: 25px;margin-top: 5px"><br/>
    Gender <input type="radio" name="sex" value="male" <%="male".equals(u.getSex())?"checked":""%>>Male
    <input type="radio" name="sex" value="female" <%= "female".equals(u.getSex())?"checked" :""%>>Female<br/>
    BirthDay <input type="text" name="birthday" value="<%=u.getBirthday()%>" style="width: 200px;height: 25px;margin-top: 5px;margin-bottom: 5px"><br/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Save Changes" style="background-color:orange;color: white;width: 100px;height: 25px;text-align: center;font-size: 15px"/>
</form>
<%@include file="footer.jsp"%>