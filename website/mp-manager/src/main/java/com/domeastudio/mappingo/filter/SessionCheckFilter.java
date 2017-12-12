package com.domeastudio.mappingo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName="pageFilter",urlPatterns="/*"
        ,initParams={@WebInitParam(name ="INCLUDED_PAGES" ,
        value = "manager.jsp"),
        @WebInitParam(name="HOMEPAGE",value = "/index.html")})

public class SessionCheckFilter implements Filter {
    private String includedPages;
    private String[] includedPageArray;
    private String homePage;

    @Override
    public void init(FilterConfig filterConfig) {
        includedPages = filterConfig.getInitParameter("INCLUDED_PAGES");
        if (null!=includedPages && includedPages.length()!=0) { // 例外页面不为空
            includedPageArray = includedPages.split(String.valueOf(';'));
        }
        homePage=filterConfig.getInitParameter("HOMEPAGE");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 获取 resquest、response、session
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        String userId = (String) session.getAttribute("userid");
        String token = (String) session.getAttribute("token");
        String role = (String) session.getAttribute("role");
        System.out.println("load file name:"+request.getServletPath());
        System.out.println("userid:"+userId);
        System.out.println("token:"+token);
        System.out.println("role:"+role);

        for (String page:includedPageArray) {
            if (request.getServletPath().substring(1).equals(page)){
                if(null!=userId&&null!=token&&null!=role){
                    filterChain.doFilter(request,response);
                }else{
                    String path=request.getContextPath();
                    response.sendRedirect(path+homePage);
                }
            }else{
                filterChain.doFilter(request,response);
            }
        }


    }

    @Override
    public void destroy() {
        this.includedPages = null;
        this.includedPageArray = null;
    }
}
