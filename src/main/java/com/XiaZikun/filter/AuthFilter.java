package com.XiaZikun.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in AuthFilter-->doFilter() - before servlet-(request come here)");//when called?

        chain.doFilter(request, response);//call nest filter - if no next filter - then go to servlet
        //response after servlet come back here
        System.out.println("i am in AuthFilter-->doFilter() - after servlet-(request come here)");
    }
}
