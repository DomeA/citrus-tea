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
        ,initParams={@WebInitParam(name ="EXCLUDED_PAGES" ,
        value = "index.html;registor.html;.do;.js;.css;.json;.png;.jpg;.gif;.woff;.woff2;.tff"),
        @WebInitParam(name="HOMEPAGE",value = "/index.html")})

public class SessionCheckFilter implements Filter {
    private String excludedPages;
    private String[] excludedPageArray;
    private String homePage;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        excludedPages = filterConfig.getInitParameter("EXCLUDED_PAGES");
        if (null!=excludedPages && excludedPages.length()!=0) { // 例外页面不为空
            excludedPageArray = excludedPages.split(String.valueOf(';'));
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
        String path=request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

        String userId = (String) session.getAttribute("userid");
        String token = (String) session.getAttribute("token");
        String role = (String) session.getAttribute("role");
        System.out.println("load file name:"+request.getServletPath());
        System.out.println("userid:"+userId);
        System.out.println("token:"+token);
        System.out.println("role:"+role);

        Boolean f=false;
        for (String page:excludedPageArray) {
            if (request.getServletPath().substring(1).contains(page)
                    ||(userId != null&&!userId.equals("null")
                    &&token!=null&&!token.equals("null")&&
                    role!=null&&!role.equals("null"))){
                f=true;
            }
        }
        if(!f){
            //request.getRequestDispatcher(path+homePage).forward(request,response);
            PrintWriter out =servletResponse.getWriter();
            //out.write(homePage);
            out.write("<a href='"+basePath+"index.html'>没有登录吧？请点我</a>");
        }else {
            filterChain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {
        this.excludedPages = null;
        this.excludedPageArray = null;
    }
}
