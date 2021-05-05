package com.XiaZikun.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/login")
public class FrontEndAuthenticationFilter implements Filter {
    private HttpServletRequest httpRequest;
    private static final String[] loginRequiredURLs = {
            "/updateUser","/logout","/myCart"
    };
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        httpRequest = (HttpServletRequest) request;

        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

        if(path.startsWith("/admin/")){
            chain.doFilter(request,response);
            return;
        }

        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("userList") != null);

        String loginURL = httpRequest.getContextPath()+"/login";
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURL);
        boolean isLoginPage = httpRequest.getRequestURI().endsWith("login");

        if(isLoggedIn && (isLoginRequest || isLoginPage)){
            //the user is already logged in and he's trying to login again
            //then forward to the homepage
            httpRequest.getRequestDispatcher("/").forward(request,response);
            System.out.println("F1");
        }else if(!isLoggedIn && isLoginRequired()){
            //the user is not logged in , and the requested page requires
            //authentication, then forward to the login page
            String loginPage = "/login";
            RequestDispatcher dispatcher=httpRequest.getRequestDispatcher(loginPage);
            dispatcher.forward(request,response);
            System.out.println("F2");
        }else{
            //for other requested pages that do not require authentication
            //or the user is already logged in, continue to the destination
            chain.doFilter(request, response);
            System.out.println("F3");
        }
    }
    private boolean isLoginRequired(){
        String requestURL = httpRequest.getRequestURI().toString();

        for (String loginRequiredURL : loginRequiredURLs){
            if(requestURL.contains(loginRequiredURL)){
                return true;
            }
        }
        return false;
    }
}//end
