<%@ page import="com.XiaZikun.week11.demo.Dog" %>
<%@ page import="com.XiaZikun.week11.demo.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/10/2021
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demo#1</title>
</head>
<body>
<h2>set attribute in 4 scopes- page , request , session ,application</h2>
<%
    pageContext.setAttribute("attname","in page");//name=value
    request.setAttribute("attname","in request");
    session.setAttribute("attname","in session");
    application.setAttribute("attname", "in application ");

%>
<h1> use findAttribute- search attname in page--> request -->session-->application </h1>
att: <%=pageContext.findAttribute("attname")%><!- which one ?-->

<h2>Use EL</h2>

${attname}<!--pageContext.findAttribute("attname")-->
<h2>Demo #2 - week 11</h2>
<%
//use person and dog bean class
 Dog dog=new Dog();
 dog.setName("Tommy");
Person person=new Person();
person.setName("TOM");
//has a dog
    person.setDog(dog);

    // must be attribute -- set attribute
    pageContext.setAttribute("person",person);
%>

<h2>Get persons' Dog name - using java code </h2>
<%
//java code
   Person p=(Person) pageContext.findAttribute("person");
   Dog d=p.getDog();
   out.println(p.getName()+"'s Dog name is -"+d.getName());
%>
<h2>Get persons' Dog name - using EL code </h2>
${person["name"]}'s dog is-${person.dog.name}



<h1>Demo #3 - Access array list and map using EL</h1>
<%
//array
    String[] firstName ={"Bill","Scott","Larry"};
//ArrayList
ArrayList<String> lastName=new ArrayList<String>();
lastName.add("Ellison");
lastName.add("Gates");
lastName.add("McNealy");
//Map
    Map<String, String> companyName=new HashMap<String,String>();
    companyName.put("Ellison","Sun");
    companyName.put("Gates","Oracle");
    companyName.put("McNealy","MicroSoft");

    //must be attribute - set attribute in any one scope
    request.setAttribute("first",firstName);//array
    request.setAttribute("last",lastName);//arraylist
    request.setAttribute("company",companyName);//map
%>
<h2>get from array , list -->  Map using EL code </h2>
${first[0]}, ${last[0]} --> ${company["Ellison"]}<br>
${first[1]}, ${last[1]} --> ${company["Gates"]}<br>
${first[2]}, ${last[2]} --> ${company["McNealy"]}<br>

<h1>Demo#4</h1>
<h2>USe EL to get request parameter</h2>
<%
String name =request .getParameter("name");
%>
${param.name}<br>
${header.host}
${cookie.JSESSIONID.value}
${initParam.url}<!--in web.xm-->
${pageContext.session.id}<!-- request.getSession().getId()-->
${pageScope.attname}
${requestScope.attname}
${sessionScope.attname}
${applicationScope.attname}<!--getAttribute()-->
</body>
</html>
