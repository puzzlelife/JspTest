package com.number7;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by dell--pc on 2017/3/28.
 */
public class loginFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        HttpSession session=request.getSession();
        if(session==null||session.getAttribute("user name")==null){
            response.sendRedirect("../pages/login.html");
        }else{
            response.setContentType("text/html;charset=utf-8");
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
