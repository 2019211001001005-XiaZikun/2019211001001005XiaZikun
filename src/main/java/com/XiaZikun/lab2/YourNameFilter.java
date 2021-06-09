package com.XiaZikun.lab2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "YourNameFilter",urlPatterns = {"/lab2/validate.jsp","/lab2/welcome.jsp"})
public class YourNameFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in YourNameFilter--> before chain");
        chain.doFilter(request, response);
        System.out.println("i am in YourNameFilter--> after chain");
    }
}
