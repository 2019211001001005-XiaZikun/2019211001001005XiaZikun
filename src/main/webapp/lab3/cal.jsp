        <%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2021/6/15
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>lab3-XiaZikun</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/cal">
    <%
        Cookie[] cookies = request.getCookies();
        Cookie cFirstValue = new Cookie("firstVar","");
        Cookie cSecondValue = new Cookie("secondVar","");
        Cookie cResult = new Cookie("result","");
        Cookie cName = new Cookie("name","");
        Cookie cLength = new Cookie("length","");
        cFirstValue.setMaxAge(15);
        cSecondValue.setMaxAge(15);
        cLength.setMaxAge(15);
        cName.setMaxAge(15);
        cResult.setMaxAge(15);
        for (int i = 0; i <= cookies.length - 1; i++) {
            if (cookies != null) {
                if (("firstVar").equals(cookies[i].getName())) {
                    cFirstValue.setValue(cookies[i].getValue());
                } else if ("secondVar".equals(cookies[i].getName())) {
                    cSecondValue.setValue(cookies[i].getValue());
                } else if ("result".equals(cookies[i].getName())) {
                    cResult.setValue(cookies[i].getValue());
                } else if ("name".equals(cookies[i].getName())) {
                    cName.setValue(cookies[i].getValue());
                } else if ("length".equals(cookies[i].getName())) {
                    cLength.setValue(cookies[i].getValue());
                }
            }
        }
    %>
    <table>
    <tr>
        <td>First Val:</td><td><input type="text" name="firstVar" id="firstVar" width="100px" value="<%=cFirstValue.getValue()%>"></td>
        <td>Enter a Name:</td><td><input type="text" name="name" id="name" width="100px" value="<%=cName.getValue()%>"></td>
    </tr>
    <tr>
        <td>Second Val:</td><td><input type="text" name="secondVar" id="secondVar" style="margin-top: 2px;";width="100px" value="<%=cSecondValue.getValue()%>"></td>
    <td>Length:</td><td><input type="text" name="length" style="margin-top: 2px";width="100px" value="<%=cLength.getValue()%>"></td>
    </tr>
    <tr><td>Result:</td><td><input type="text" name="result" style="margin-top: 2px;margin-bottom: 2px;";width="100px" value="<%=cResult.getValue()%>"></td> </tr>
    </table>
    <input type="submit" name="action" value="add" onclick="number()">
    <input type="submit" name="action" value="subtract" onclick="number()">
    <input type="submit" name="action" value="multiply" onclick="number()">
    <input type="submit" name="action" value="divide" onclick="number()">
    <input type="submit" name="action" value="computeLength" onclick="nameTest()">
    <input type="reset" name="reset" value="Reset">
    <script>
        function number(){
            var vv=document.getElementById("firstVar").value;
            var vv1=document.getElementById("secondVar").value;
            var re = /^[0-9]+.?[0-9]*$/;
            if (!re.test(vv)){
                alert("First Var is not a Number")
                return false;
            } else if (!re.test(vv1)){
                alert("Second Var is not a Number")
                return false;
            }
        }
        function  nameTest(){
            var str=document.getElementById("name").value;
            var req = /^[a-z]+$/;
            if (!req.test(str)){
                alert("Name is not Valid")
                return false;
            }
        }
    </script>
</form>
</body>
</html>
