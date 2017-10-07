package servlet;

import work.QinQiu;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserFilter implements Filter{
    @Override public void init(FilterConfig filterConfig) throws ServletException {}
    @Override public void destroy() {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        if (request.getRequestURI().contains("login")){          //访问的是login，不过滤
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        } else if (session.getAttribute("account")==null && QinQiu.zhuan("account", request)==null){   //没登录，也没打算登录
            response.sendRedirect("/login/login.jsp");
            return;
        } else if (QinQiu.zhuan("logout", request)!=null){       //登出
            session.removeAttribute("account");
            response.sendRedirect("/login/login.jsp");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
