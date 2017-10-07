<%@ page import="work.DBUtils" %>
<%@ page import="work.QinQiu" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="html/header.html"/>



  <%
      if (request.getParameter("gaimi")!=null)      request.setAttribute("no", session.getAttribute("account"));
      request.setAttribute("gaimi", request.getParameter("gaimi"));
      String flag = request.getParameter("flag");
      boolean isEdit = (request.getParameter("edit")!=null);
      if (isEdit){              //修改数据逻辑
          String no = request.getParameter("no");
          if (no==null)     no = (String) request.getAttribute("no");   //改自己密码，
          ResultSet resultSet = DBUtils.quuery("SELECT * FROM "+flag+" WHERE "+QinQiu.getZhuJian(flag)+"='"+no+"' ");  //修改逻辑
          try {
              resultSet.next();
              request.setAttribute("edit", "a");
              if (QinQiu.USER.equals(flag)) QinQiu.getUerEdit(resultSet, request);
              request.setAttribute("one",   resultSet.getString(1));
              request.setAttribute("two",   resultSet.getString(2));
              request.setAttribute("three", resultSet.getString(3));
              request.setAttribute("four",  resultSet.getString(4));
              request.setAttribute("five",  resultSet.getString(5));
              request.setAttribute("six",   resultSet.getString(6));
              request.setAttribute("seven", resultSet.getString(7));
              request.setAttribute("eight", resultSet.getString(8));
              request.setAttribute("nine",  resultSet.getString(9));
          } catch (Exception e){System.out.println("resultset EL: too long");}
      }
  %>

<link href="/html/Wopop_files/style_log.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/html/Wopop_files/style.css">
<link rel="stylesheet" type="text/css" href="/html/Wopop_files/userpanel.css">
<link rel="stylesheet" type="text/css" href="/html/Wopop_files/jquery.ui.all.css">
<div class="login_boder">
    <div class="login_padding" id="login_model">
    <form action="addData.jsp" >
  <%  //选择显示输入种类
      if (QinQiu.STUDENT.equals(request.getParameter("flag"))){
          %>
        <h2>学号:</h2> <input type="text" name="sno"   value="${requestScope.one}"   class="txt_input txt_input2">
        <h2>姓名:</h2> <input type="text" name="sname" value="${requestScope.two}"   class="txt_input txt_input2">
        <h2>性别:</h2> <input type="text" name="ssex"  value="${requestScope.three}" class="txt_input txt_input2">
        <h2>年龄:</h2> <input type="text" name="sage"  value="${requestScope.four}"  class="txt_input txt_input2">
        <h2>系名:</h2> <input type="text" name="sdept" value="${requestScope.five}"  class="txt_input txt_input2">
        <input name="flag" value="student" hidden>
        <input name="${empty requestScope.edit ? "hehe":"edit"}" value="a" hidden>
        <%
      } else if (QinQiu.TEACHER.equals(request.getParameter("flag"))){
        %>
        <h2>教工号:</h2>   <input type="text" name="tno"   type="text" maxlength="20" value="${requestScope.one}" class="txt_input txt_input2">
        <h2>姓名:</h2>   <input type="text" name="tname" type="text" maxlength="20" value="${requestScope.two}" class="txt_input txt_input2">
        <h2>性别:</h2>     <input type="text" name="tsex"  type="text" maxlength="1"  value="${requestScope.three}" placeholder="男或女"  class="txt_input txt_input2">
        <h2>年龄:</h2>     <input type="text" name="tage"  type="text" maxlength="4"  value="${requestScope.four}" placeholder="14--70"  class="txt_input txt_input2">
        <h2>学历:</h2>     <input type="text" name="teb"   type="text" maxlength="10" value="${requestScope.five}" class="txt_input txt_input2">
        <h2>职称:</h2>     <input type="text" name="tpt"   type="text" maxlength="10" value="${requestScope.six}" class="txt_input txt_input2">
        <h2>主讲课程1:</h2> <input type="text" name="cno1"  type="text" maxlength="6"  value="${requestScope.seven}" class="txt_input txt_input2">
        <h2>主讲课程2:</h2> <input type="text" name="cno2"  type="text" maxlength="6"  value="${requestScope.eight}" class="txt_input txt_input2">
        <h2>主讲课程3:</h2> <input type="text" name="cno3"  type="text" maxlength="6"  value="${requestScope.nine}" class="txt_input txt_input2">
        <input name="flag" value="teacher" hidden>
        <input name="${empty requestScope.edit ? "hehe":"edit"}" value="a" hidden>
         <%
      } else if (QinQiu.DEPARTMENT.equals(request.getParameter("flag"))){
        %>
        <h2>系编号:</h2> <input type="text"  name="dno"      type="text" maxlength="3"  value="${requestScope.one}" class="txt_input txt_input2">
        <h2>系名:</h2>   <input type="text"  name="dname"    type="text" maxlength="30" value="${requestScope.two}" class="txt_input txt_input2">
        <h2>系主任:</h2> <input type="text"  name="dmanager" type="text" maxlength="8"  value="${requestScope.three}" class="txt_input txt_input2">
        <input name="flag" value="department" hidden>
        <input name="${empty requestScope.edit ? "hehe":"edit"}" value="a" hidden>
        <%
      } else if (QinQiu.COURSE.equals(request.getParameter("flag"))){
          %>
        <h2>课程号:</h2>    <input type="text" name="cno"     type="text" maxlength="6"  value="${requestScope.one}" class="txt_input txt_input2">
        <h2>课程名:</h2>    <input type="text" name="cname"   type="text" maxlength="50" value="${requestScope.two}" class="txt_input txt_input2">
        <h2>先修课编号:</h2> <input type="text" name="cpno"    type="text" maxlength="6"  value="${requestScope.three}" class="txt_input txt_input2">
        <h2>学分:</h2>      <input type="text" name="ccredit" type="text" maxlength="2"  value="${requestScope.four}" class="txt_input txt_input2">
        <input name="flag" value="course" hidden>
        <input name="${empty requestScope.edit ? "hehe":"edit"}" value="a" hidden>
            <%
      } else if (QinQiu.SCT.equals(request.getParameter("flag"))){
            %>
        <h2>课程号:</h2> <input type="text" name="sno"   type="text"  maxlength="9" value="${requestScope.one}"   class="txt_input txt_input2">
        <h2>课程号:</h2> <input type="text" name="cno"   type="text"  maxlength="6" value="${requestScope.two}"   class="txt_input txt_input2">
        <h2>教工号:</h2> <input type="text" name="tno"   type="text"  maxlength="8" value="${requestScope.three}" class="txt_input txt_input2">
        <h2>成绩:</h2>   <input type="text" name="grade" type="text"  maxlength="4" value="${requestScope.four}"  class="txt_input txt_input2">
        <input name="flag" value="sct" hidden>
        <input name="${empty requestScope.edit ? "hehe":"edit"}" value="a" hidden>
  <%
      } else if (QinQiu.USER.equals(request.getParameter("flag"))){
  %>
      <h2>用户名:</h2> <input name="username" type="text"     maxlength="15" value="${requestScope.one}" class="txt_input txt_input2">
      <h2>密码:</h2>   <input name="password" type="password" maxlength="20" value="${requestScope.two}" class="txt_input txt_input2">
      <div style="font-size: 15px; font-family: Arial, Helvetica, sans-serif" id="xunzekuang">
      学生表权限：浏览&nbsp&nbsp<input name="student"     type="checkbox" value="1" ${n1}>&nbsp
                报表&nbsp&nbsp<input name="student"     type="checkbox" value="2" ${n2}>&nbsp
                编辑&nbsp&nbsp<input name="student"     type="checkbox" value="3" ${n3}><br>
      教工表权限：浏览&nbsp&nbsp<input name="teacher"     type="checkbox" value="1" ${n4}>&nbsp
                报表&nbsp&nbsp<input name="teacher"     type="checkbox" value="2" ${n5}>&nbsp
                编辑&nbsp&nbsp<input name="teacher"     type="checkbox" value="3" ${n6}><br>
      院系表权限：浏览&nbsp&nbsp<input name="department"  type="checkbox" value="1" ${n7}>&nbsp
                报表&nbsp&nbsp<input name="department"  type="checkbox" value="2" ${n8}>&nbsp
                编辑&nbsp&nbsp<input name="department"  type="checkbox" value="3" ${n9}><br>
      课程表权限：浏览&nbsp&nbsp<input name="course"      type="checkbox" value="1" ${n10}>&nbsp
                报表&nbsp&nbsp<input name="course"      type="checkbox" value="2" ${n11}>&nbsp
                编辑&nbsp&nbsp<input name="course"      type="checkbox" value="3" ${n12}><br>
      选课表权限：浏览&nbsp&nbsp<input name="sct"         type="checkbox" value="1" ${n13}>&nbsp
                报表&nbsp&nbsp<input name="sct"         type="checkbox" value="2" ${n14}>&nbsp
                编辑&nbsp&nbsp<input name="sct"         type="checkbox" value="3" ${n15}><br>
      用户表权限：浏览&nbsp&nbsp<input name="user"        type="checkbox" value="1" ${n16}>&nbsp
                报表&nbsp&nbsp<input name="user"        type="checkbox" value="2" ${n17}>&nbsp
                编辑&nbsp&nbsp<input name="user"        type="checkbox" value="3" ${n18}><br>
      </div>
      <input name="flag" value="user" hidden>
      <input name="${empty requestScope.edit ? "hehe":"edit"}" value="a" hidden>
      <input name="${empty requestScope.gaimi ? "haha":"gaimi"}" value="a" hidden>
  <%
      }
  %>
        <p class="forgot"><a id="iforget" href="javascript:void(0);"></a></p>
        <div class="rem_sub" style="text-align: right">
            <label>
                <input type="submit" class="sub_button" name="button" id="button" value="提交" style="opacity: 0.7;">
            </label>
        </div>
      </form>
    </div>
</div>

<%
    QinQiu qius = new QinQiu();                             //插入数据的逻辑
    String[] arr = qius.getParameterArr(request, flag);
    if (!qius.isKong())   DBUtils.insert(arr, out, flag, isEdit);
%>


<%
    if (request.getParameter("gaimi")!=null){                          //用户改自己密码, 禁用编辑
%>
<script language="JavaScript">
    var i = 0;
    var list = document.getElementsByName("student");
    for (i=0; i<list.length; i++)   list[i].setAttribute("onclick", "return false");
    list = document.getElementsByName("teacher");
    for (i=0; i<list.length; i++)   list[i].setAttribute("onclick", "return false");
    list = document.getElementsByName("department");
    for (i=0; i<list.length; i++)   list[i].setAttribute("onclick", "return false");
    list = document.getElementsByName("course");
    for (i=0; i<list.length; i++)   list[i].setAttribute("onclick", "return false");
    list = document.getElementsByName("sct");
    for (i=0; i<list.length; i++)   list[i].setAttribute("onclick", "return false");
    list = document.getElementsByName("user");
    for (i=0; i<list.length; i++)   list[i].setAttribute("onclick", "return false");
    document.getElementsByName("username")[0].setAttribute("readonly", "true");
</script>
<%
    }
%>

<jsp:include page="html/footer.html"/>


