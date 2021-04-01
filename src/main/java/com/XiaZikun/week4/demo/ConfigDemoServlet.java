package com.XiaZikun.week4.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name="name", value = "XiaZikun"),
                @WebInitParam(name="studentid", value = "2019211001001005"),
        }
)
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        String name=config.getInitParameter("name"); //<param-name>name</param-name>
        String studentid=config.getInitParameter("studentid");
        PrintWriter writer = response.getWriter();
        writer.println("<br>name : "+name);
        writer.println("<br>studentid : "+studentid);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
