package com.XiaZikun.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(
        urlPatterns = {"/register"}
)
//automatic -new --> servlet
public class RegisterServlet extends HttpServlet {
    Connection con=null; //class variable
    @Override
    public void init() throws ServletException{
        //only one connection
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url="jdbc:sqlserver://localhost:1433;DatabaseName=userdb";
        //String username="sa";
        //String password="123456";
        //code like this is bad way --because change in not easy
        //for example change password of db = change in java code

        //get servletconfig --> getInitParameters --no change
        /*String driver=getServletConfig().getServletContext().getInitParameter("driver");
        String url=getServletConfig().getServletContext().getInitParameter("url");
        String username=getServletConfig().getServletContext().getInitParameter("username");
        String password=getServletConfig().getServletContext().getInitParameter("password");

        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con); //ok(use java code) -ok (use config in web.xml) -ok --use(@webservlet)
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        con=(Connection) getServletContext().getAttribute("con");//name of attribute
        //please check the video live demo#4

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// request come here
        //get parameter from request.
        PrintWriter writer = response.getWriter();
        String username =request.getParameter("username");//name of input type -<input type="text" name = "username"/><br/>
        String password =request.getParameter("password");
        String email =request.getParameter("email");
        String sex =request.getParameter("gender");
        String birthday =request.getParameter("birthday");
        System.out.println(""+username);
        System.out.println(""+password);
        System.out.println(""+email);
        System.out.println(""+sex);
        System.out.println(""+birthday);
        PreparedStatement pstmt= null; //调用javaSQL包的PreparedStatement来存储待运行的SQL语句
        try {
            String sql="insert into usertable(username,password,email,sex,birthday)  values(?,?,?,?,?) ";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.setString(3,email);
            pstmt.setString(4,sex);
            pstmt.setString(5,birthday);
            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



        //here is html code --- move these html code in a jsp page - userlist.jsp
        //writer.println()
        //get one by one
        /* writer.print("<html>");
        writer.print("<table border='1'>");
        writer.print("<tr>");
        writer.print("<td>ID</td>");
        writer.print("<td>UserName</td>");
        writer.print("<td>Password</td>");
        writer.print("<td>Email</td>");
        writer.print("<td>Sex</td>");
        writer.print("<td>BirthDay</td>");
        writer.print("</tr>");*/
        //try {
            //String sql_1="select * from usertable";
            //ResultSet rs=con.createStatement().executeQuery(sql_1);
            //PrintWriter out = response.getWriter();
            /*while(rs.next()){
                //get from rs - print - write into response
                writer.print("<tr>");
                writer.print("<td>"+rs.getString(1));
                writer.print("</td>");
                writer.print("<td>"+rs.getString(2));
                writer.print("</td>");
                writer.print("<td>"+rs.getString(3));
                writer.print("</td>");
                writer.print("<td>"+rs.getString(4));
                writer.print("</td>");
                writer.print("<td>"+rs.getString(5));
                writer.print("</td>");
                writer.print("<td>"+rs.getString(6));
                writer.print("</td>");
                writer.print("</tr>");
            }*/

            //use request attribute
            //set rs into request attribute
            //request.setAttribute("rsname",rs);//name - string,value -any type (object)

            //request.getRequestDispatcher("userlist.jsp").forward(request,response);
            //at this point request given to userlist.jsp
            //url doesnot change
            //no more here
            //System.out.println("i am in RequestServlet2-->doPost()--> after forward()"); //no see this line
            //ok -done
            //after register a new user - user can login
            response.sendRedirect("login");
        //} catch (SQLException throwables) {
          //  throwables.printStackTrace();
        //}
        //writer.print("</table>");
        //writer.print("</html>");

        //print - write into response


    }
    @Override
    public void destroy(){
        super.destroy();
        try {
            con.close(); //when tomcat stop
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
