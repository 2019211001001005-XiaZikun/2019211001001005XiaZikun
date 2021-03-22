package week3.exercise;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//automatic -new --> servlet
public class exercise extends HttpServlet {
    public void closeCon(Connection con) throws Exception {
        if (con != null) {
            con.close();
        }
    }

    public Connection getCon()throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = null;
        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=userdb ", "sa", "123456");
        return con;
    }

    public String[] getValue(){
        StringBuffer sqlString = new StringBuffer("select * from usertable");
        String[] strArray = new String [5];
        Connection con = null;
        try {
            con = getCon();
            PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
            ResultSet executeQuery = preparedStatement.executeQuery();
            while (executeQuery.next()) {
                strArray[0]=executeQuery.getString("username");
                strArray[1]=executeQuery.getString("password");
                strArray[2]=executeQuery.getString("email");
                strArray[3]=executeQuery.getString("sex");
                strArray[4]=executeQuery.getString("birthday");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                closeCon(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return strArray;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// request come here
        //get parameter from request.
        String[] strArray=getValue();
        String username =strArray[0];//name of input type -<input type="text" name = "username"/><br/>
        String password =strArray[1];
        String email =strArray[2];
        String sex =strArray[3];
        String birthday =strArray[4];

        //print - write into response
        PrintWriter writer = response.getWriter();
        writer.println("<br>username :"+username);
        writer.println("<br>password :"+password);
        writer.println("<br>email :"+email);
        writer.println("<br>sex :"+sex);
        writer.println("<br>birthday :"+birthday);
        writer.close();
    }
}
