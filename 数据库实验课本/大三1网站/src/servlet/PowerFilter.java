package servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PowerFilter implements Filter{
    @Override public void init(FilterConfig filterConfig) throws ServletException {}
    @Override public void destroy() {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        String showPower, baoPower, editPower;
        showPower = (String) session.getAttribute("showPower");
        baoPower = (String) session.getAttribute("baoPower");
        editPower = (String) session.getAttribute("editPower");
        if (showPower==null || showPower.length()==0)   showPower = "#";
        if (baoPower==null || baoPower.length()==0)     baoPower = "#";
        if (editPower==null || editPower.length()==0)   editPower = "#";

        String url = request.getRequestURI();
        boolean nowPower = true;
        if (url.contains("showAll.jsp") && !showPower.contains(request.getParameter("flag")))   nowPower = false;
        if (url.contains("baoAll.jsp") && !baoPower.contains(request.getParameter("flag")))     nowPower = false;
        if (url.contains("editAll.jsp") && !editPower.contains(request.getParameter("flag")))   nowPower = false;
        if (url.contains("addData.jsp") && !editPower.contains(request.getParameter("flag")))   nowPower = false;
        if (nowPower)           filterChain.doFilter(servletRequest, servletResponse);
        else    {
            response.sendRedirect("main.jsp?noPower=a");
        }
    }

}
