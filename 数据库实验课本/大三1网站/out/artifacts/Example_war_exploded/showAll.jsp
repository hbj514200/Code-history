<%@ page import="work.DBUtils" %>
<%@ page import="work.ShowList" %>
<%@ page import="work.QinQiu" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="html/header.html"/>

  <%
      String flag = request.getParameter("flag");    //显示的类别,分页部分
      int nowPage = (request.getParameter("nowPage")==null)?0: Integer.parseInt(request.getParameter("nowPage"));  //获取请求页码
      if (nowPage<0)    nowPage = 0;
      int zongYe = DBUtils.getCount(flag) /30 + 1;
      if (nowPage > zongYe-1)    nowPage--;
      request.setAttribute("flag", flag);
  %>


<link rel="stylesheet" type="text/css" href="/html/css/search.css" />
    <form action="showAll.jsp" class="form-wrapper cf">
      <input name="search" type="text" required id="ins" placeholder="search……"/>
      <input name="nowPage" type="text" value="1" hidden />
      <input name="flag" type="text" value="${requestScope.flag}" hidden/>
      <button type="submit" id="inb">查询</button>
    </form>


<link rel="stylesheet" type="text/css" href="/html/list/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="/html/list/css/demo.css" />
<link rel="stylesheet" type="text/css" href="/html/list/css/component.css" />
  <%
      if (request.getParameter("search")==null)
          out.print(ShowList.getListHtml(DBUtils.getConnection().createStatement().executeQuery("SELECT * FROM "+ flag +" LIMIT "+(nowPage*30)+", 30"), QinQiu.getLieMin(flag)));
      else
          out.print(ShowList.getListHtml(DBUtils.showQuuery(flag, request.getParameter("search")), QinQiu.getLieMin(flag)));
  %>

<link rel="stylesheet" type="text/css" href="/html/css/fanye.css" />
<div style="text-align: center; margin-top: -30px; margin-bottom: 25px">
    <a href="showAll.jsp?flag=<%=flag%>&nowPage=<%=nowPage-1%>" class="button back" style="color:#555">上一页</a>
    <font style="color: #278F69; font-size: 30px; padding:0 40px 0 40px; ">第<%=nowPage%>页</font>
    <a href="showAll.jsp?flag=<%=flag%>&nowPage=<%=nowPage+1%>" class="button next" style="color:#555">下一页</a>
</div>


<jsp:include page="html/footer.html"/>

<style>



</style>