<%@ page import="work.DBUtils" %>
<%@ page import="work.ShowList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="html/header.html"/>

  <%
      String flag = request.getParameter("flag");                                                                  //显示的类别
      int nowPage = (request.getParameter("nowPage")==null)?0: Integer.parseInt(request.getParameter("nowPage"));  //获取请求页码
      if (nowPage<0)    nowPage = 0;
      int zongYe = DBUtils.getCount(flag) /30 + 1;
      if (nowPage > zongYe-1)    nowPage--;

      String[] lieMin = null;
      if (flag.equals("student"))     lieMin = new String[]{"学号", "姓名", "性别", "年龄", "系别", "操作"};
      if (flag.equals("teacher"))     lieMin = new String[]{"教工号", "姓名", "性别", "年龄", "学历", "职称", "主讲课程1", "主讲课程2", "主讲课程3", "操作"};
      if (flag.equals("department"))  lieMin = new String[]{"系编号", "系名", "系主任", "操作"};
      if (flag.equals("course"))      lieMin = new String[]{"课程号", "课程名", "先修课程号", "学分", "操作"};
      if (flag.equals("sct"))         lieMin = new String[]{"学号", "课程号", "教工号", "成绩", "隐藏", "操作"};
      if (flag.equals("user"))        lieMin = new String[]{"用户名", "密码", "学生表权限", "教工表权限", "课程表权限", "院系表权限", "选课表权限", "用户表权限", "操作"};

      DBUtils.delete(request, out, request.getParameter("flag"));      //删除条目
      request.setAttribute("flag", flag);
  %>

<link rel="stylesheet" type="text/css" href="/html/css/search.css" />
<form action="editAll.jsp" class="form-wrapper cf">
    <input name="search" type="text" required id="ins" placeholder="search……"/>
    <input name="nowPage" type="text" value="1" hidden />
    <input name="flag" type="text" value="${requestScope.flag}" hidden/>
    <button type="submit" id="inb">查询</button>
</form>

<link rel="stylesheet" type="text/css" href="/html/list/css/normalize.css" />     <!--显示列表的部分-->
<link rel="stylesheet" type="text/css" href="/html/list/css/demo.css" />
<link rel="stylesheet" type="text/css" href="/html/list/css/component.css" />

<%
    if (request.getParameter("search")==null)
        out.print(ShowList.getListBianJi(DBUtils.getConnection().createStatement().executeQuery("SELECT * FROM "+ flag +" LIMIT "+(nowPage*30)+", 30"), lieMin, flag, nowPage));
    else
        out.print(ShowList.getListBianJi(DBUtils.showQuuery(flag, request.getParameter("search")), lieMin, flag, nowPage));
%>

<link rel="stylesheet" type="text/css" href="/html/css/fanye.css" />
<div style="text-align: center; margin-top: -30px; margin-bottom: 25px">
    <a href="editAll.jsp?flag=<%=flag%>&nowPage=<%=nowPage-1%>" class="button back" style="color:#555">上一页</a>
    <font style="color: #278F69; font-size: 30px; padding:0 40px 0 40px; ">第<%=nowPage%>页</font>
    <a href="editAll.jsp?flag=<%=flag%>&nowPage=<%=nowPage+1%>" class="button next" style="color:#555">下一页</a>
</div>

<jsp:include page="html/footer.html"/>


