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

<link rel="stylesheet" type="text/css" href="/html/css/baoButton.css" />
<div style="text-align: right; padding-right: 12%; margin-top: 20px; margin-bottom: -30px">
    <button value="打印" onclick="dayin()" id="daoButton">打印</button>
    <button value="导出" onclick="daochuURL()" id="daoButton2" >导出</button>
</div>

<link rel="stylesheet" type="text/css" href="/html/list/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="/html/list/css/demo.css" />
<link rel="stylesheet" type="text/css" href="/html/list/css/component.css" />
  <div id="yinQu">
  <%
      if (flag.equals(QinQiu.SCT)){
          out.print(ShowList.getListHtml(DBUtils.getConnection().createStatement().executeQuery("SELECT sct.sno,sct.cno,sct.tno,grade,xvhao,sname,cname,tname FROM sct,student,teacher,course"), QinQiu.getLieMin("sctbao")));
          session.setAttribute("outputCSV", ShowList.getListHtml(DBUtils.getConnection().createStatement().executeQuery("SELECT sct.sno,sct.cno,sct.tno,grade,xvhao,sname,cname,tname FROM sct,student,teacher,course"), QinQiu.getLieMin("sctbao")));
      }
      else {
          out.print(ShowList.getListHtml(DBUtils.getConnection().createStatement().executeQuery("SELECT * FROM "+ flag), QinQiu.getLieMin(flag)));
          session.setAttribute("outputCSV", ShowList.getListHtml(DBUtils.getConnection().createStatement().executeQuery("SELECT * FROM "+ flag), QinQiu.getLieMin(flag)));
      }
  %>
 </div>
<link rel="stylesheet" type="text/css" href="/html/css/fanye.css" />
<div style="text-align: center; margin-top: -30px; margin-bottom: 25px">
    <a href="baoAll.jsp?flag=<%=flag%>&nowPage=<%=nowPage-1%>" class="button back" style="color:#555">上一页</a>
    <font style="color: #278F69; font-size: 30px; padding:0 40px 0 40px; ">第<%=nowPage%>页</font>
    <a href="baoAll.jsp?flag=<%=flag%>&nowPage=<%=nowPage+1%>" class="button next" style="color:#555">下一页</a>
</div>

<jsp:include page="html/footer.html"/>


<script language="JavaScript">
    function dayin(){
        var bodyHTML=window.document.body.innerHTML;
        window.document.body.innerHTML=document.getElementById("yinQu").innerHTML;
        window.print();
        window.document.body.innerHTML=bodyHTML;
    }

    function daochuURL(){
            window.location="downloadcsv";
    }
</script>
