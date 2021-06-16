package com.XiaZikun.lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CalServlet", value = "/cal")
public class CalServlet extends HttpServlet {
    private int add(int firstVal,int secondVal){
        return firstVal+secondVal;
    }
    private int subtract(int firstVal,int secondVal){
        return firstVal-secondVal;
    }
    private int multiply(int firstVal,int secondVal){
        return firstVal*secondVal;
    }
    private int divide(int firstVal,int secondVal){
        return firstVal/secondVal;
    }
    private int computeLength(String name) {
        int n = 0;
        for (int i = 0; i < name.length(); i++) {
            //获取字符串的字符
            char ch = name.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                n++;
            } else if (ch >= 'A' && ch <= 'Z') {
                n++;
            }else if(ch>='0' && ch<='9') {
                n++;
            }
        }
        return n;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        todo 7: use if else to determine action is add or subtract or multiply or divide or computerLength
//        todo 8 : call method add, subtract , multiply, divide or computeLength based on action and get the calculated result
//        todo 9: if action =add or subtract or multiply or divide
//        todo 10 :create 3 cookie name cFirstValue, cSecondValue,cResult and set the value of cookie
//        todo 11 : add 3 cookies into response
//        todo 12: if action =computeLength
//        todo 13 :create 2 cookies name cName, cLength and set the value
//        todo 14 : add 2 cookies into response
//        todo 13 : send redirect to cal.jsp

        String firstVar=request.getParameter("firstVar");
        String secondVar=request.getParameter("secondVar");
        String name=request.getParameter("name");
        if (request.getParameter("action").equals("add")) {
            int result=add(Integer.parseInt(firstVar), Integer.parseInt(secondVar));
            System.out.println(firstVar+","+secondVar+","+result);
            Cookie cFirstValue = new Cookie("firstVar",firstVar);
            cFirstValue.setMaxAge(15);
            Cookie cSecondValue = new Cookie("secondVar",secondVar);
            cSecondValue.setMaxAge(15);
            Cookie cResult = new Cookie("result",String.valueOf(result));
            cResult.setMaxAge(15);
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
        } else if (request.getParameter("action").equals("subtract")) {
            int result=subtract(Integer.parseInt(firstVar), Integer.parseInt(secondVar));
            System.out.println(firstVar+","+secondVar+","+result);
            Cookie cFirstValue = new Cookie("firstVar",firstVar);
            cFirstValue.setMaxAge(15);
            Cookie cSecondValue = new Cookie("secondVar",secondVar);
            cSecondValue.setMaxAge(15);
            Cookie cResult = new Cookie("result",String.valueOf(result));
            cResult.setMaxAge(15);
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
        } else if (request.getParameter("action").equals("multiply")) {
            int result=multiply(Integer.parseInt(firstVar), Integer.parseInt(secondVar));
            System.out.println(firstVar+","+secondVar+","+result);
            Cookie cFirstValue = new Cookie("firstVar",firstVar);
            cFirstValue.setMaxAge(15);
            Cookie cSecondValue = new Cookie("secondVar",secondVar);
            cSecondValue.setMaxAge(15);
            Cookie cResult = new Cookie("result",String.valueOf(result));
            cResult.setMaxAge(15);
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
        } else if (request.getParameter("action").equals("divide")) {
            int result=divide(Integer.parseInt(firstVar), Integer.parseInt(secondVar));
            System.out.println(firstVar+","+secondVar+","+result);
            Cookie cFirstValue = new Cookie("firstVar",firstVar);
            cFirstValue.setMaxAge(15);
            Cookie cSecondValue = new Cookie("secondVar",secondVar);
            cSecondValue.setMaxAge(15);
            Cookie cResult = new Cookie("result",String.valueOf(result));
            cResult.setMaxAge(15);
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
        } else if (request.getParameter("action").equals("computeLength")) {
            int length=computeLength(name);
            System.out.println(name+","+length);
            Cookie cName = new Cookie("name",name);
            cName.setMaxAge(15);
            Cookie cLength = new Cookie("length",String.valueOf(length));
            cLength.setMaxAge(15);
            response.addCookie(cName);
            response.addCookie(cLength);
        }
        response.sendRedirect("lab3/cal.jsp");
    }
}
