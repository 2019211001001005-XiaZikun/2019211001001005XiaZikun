package com.XiaZikun.lab3;

        import javax.servlet.*;
        import javax.servlet.http.*;
        import javax.servlet.annotation.*;
        import java.io.IOException;
        import java.io.PrintWriter;
        import java.io.Writer;

@WebServlet(name = "HitCountServlet", value = "/hitCount")
public class HitCountServlet extends HttpServlet {
    int n=0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        n++;
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<title>");
        writer.println("hitCount");
        writer.println("</title>");
        writer.println("<style>");
        writer.println("body{text-align:center;font-family:宋体;font-size:25px};margin:0 auto");
        writer.println("</style>");
        writer.println("Total Numbers of Hit");
        writer.println("<br/>");
        writer.println(""+n);
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
