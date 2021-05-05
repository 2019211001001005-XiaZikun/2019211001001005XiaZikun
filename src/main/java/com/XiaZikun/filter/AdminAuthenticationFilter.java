package com.XiaZikun.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/login")
public class AdminAuthenticationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest=(HttpServletRequest) request;
        HttpServletResponse httpResponse=(HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("userList")!=null);
        String loginURL = httpRequest.getContextPath() + "/admin/login";
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURL);
        boolean isLoginPage = httpRequest.getRequestURI().equals(loginURL);

        if(isLoggedIn && (isLoginPage || isLoginRequest)){
            //the admin is already logged in and he is trying to login again
            //then forwards to the admin's homepage
            RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/home");
            dispatcher.forward(request,response);
            System.out.println("A1");
        }else if(isLoggedIn || isLoginRequest){
            //continues the filter chain
            //allows the request to reach the destination
            chain.doFilter(request, response);
            System.out.println("A2");
        }else{
            //the admin is not logged in , so authentication is required
            //forwards to the Login page
            httpResponse.sendRedirect(httpRequest.getContextPath()+"/admin/login");
            System.out.println("A3");
        }

    }
}//end class
