package com.domeastudio.mappingo.manager;


import com.domeastudio.mappingo.util.JsonStringUtil;
import com.domeastudio.mappingo.util.security.BASE64Helper;
import us.monoid.json.JSONObject;
import us.monoid.web.JSONResource;
import us.monoid.web.Resty;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@WebServlet(name="managerServlet",urlPatterns="/login.do",
        loadOnStartup=1)
public class ManagerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/site.properties");
        Properties prop = new Properties();
        prop.load(in);
        String url = prop.getProperty("loginUrl");

        HttpSession session=req.getSession();
        String path=req.getContextPath();

        try {
            Resty resty=new Resty();
            Map<String,String> login=new HashMap<>();
            login.put("userName",req.getParameter("userName").toString());
            login.put("password",req.getParameter("password").toString());
            JSONObject jsonObject=new JSONObject(login);
            JSONResource jsonResource = resty.identifyAsMozilla().json(url,Resty.content(jsonObject));
            if(jsonResource.get("code").equals(200)){

                String tokenStr = jsonResource.get("data.access_token").toString();
                String[] authArry = tokenStr.split("\\.");
                String str = new String(BASE64Helper.decryptBASE64(authArry[1]));
                Map<String, String> user = JsonStringUtil.toMap(str);
                if(user.get("role").compareTo("ROLE_SYSADMIN")==0){
                    session.setAttribute("token", tokenStr);
                    session.setAttribute("role",user.get("role"));
                    session.setAttribute("userid", user.get("userid"));
                    session.setAttribute("token_type",jsonResource.get("data.token_type").toString());
                    resp.setHeader("Authorization", "bearer " + tokenStr);
                    resp.sendRedirect(path+"/manager.jsp");
                }else {
                    session.removeAttribute("token");
                    session.removeAttribute("role");
                    session.removeAttribute("userid");
                    session.removeAttribute("token_type");
                    resp.setContentType("text/html;charset=utf-8");
                    resp.getWriter().write("你不是管理员角色，请联系管理员赋给你相应的角色！");
                }
            }else{
                session.removeAttribute("token");
                session.removeAttribute("role");
                session.removeAttribute("userid");
                session.removeAttribute("token_type");
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("用户名或密码错误！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
