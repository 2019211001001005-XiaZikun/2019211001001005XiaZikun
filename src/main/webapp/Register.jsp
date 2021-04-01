<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2021/3/21
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1 style="color: gray">New User Registration!</h1>
<form method="post" action="${pageContext.request.contextPath}/register2"> <!-- what is method when wo use form?--><!--its GET , why? default is GET,form data is added in the URL,you can see-->
    <!-- its better to use POST in form,data in not added in the URL-->
    UserName <input type="text" name="Username" placeholder="Username" style="width: 200px;height: 25px;margin-top: 2px"><br/>
    PassWord <input type="password" name="password" placeholder="password" style="width: 200px;height: 25px;margin-top: 5px"><br/>
    Email <input type="text" name="Email" placeholder="Email" style="width: 200px;height: 25px;margin-top: 5px"><br/>
    Gender <input type="radio" name="sex" value="male" checked="checked">Male
    <input type="radio" name="sex" value="female">Female<br/>
    BirthDay <input type="text" name="birthday" placeholder="Date of Birth(yyyy-mm-dd)" style="width: 200px;height: 25px;margin-top: 5px;margin-bottom: 5px"><br/>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="register" style="background-color:orange;color: white;width: 100px;height: 25px;text-align: center;font-size: 15px"/>
</form>

<%@include file="footer.jsp"%>


