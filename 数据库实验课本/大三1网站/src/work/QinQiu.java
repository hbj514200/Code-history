package work;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;

public class QinQiu {
    public static String STUDENT = "student";
    public static String TEACHER = "teacher";
    public static String COURSE = "course";
    public static String DEPARTMENT = "department";
    public static String SCT = "sct";
    public static String USER = "user";
    public static String[] SIXBIAO = new String[]{QinQiu.STUDENT, QinQiu.TEACHER, QinQiu.DEPARTMENT, QinQiu.COURSE, QinQiu.SCT, QinQiu.USER};
    private String sno,sname,ssex,sage,sdept,tno,tname,tsex,tage,teb,tpt,cno1,cno2,cno3,dno,dname,dmanager,cno,cname,cpno,ccredit,grade,
            username,password,student,teacher,department,course,sct,user;
    private boolean isKong = true;  //是否位参数全空

    private void getValues(HttpServletRequest request){
        sno = zhuan("sno", request);
        sname = zhuan("sname", request);
        ssex = zhuan("ssex", request);
        sage = zhuan("sage", request);
        sdept = zhuan("sdept", request);
        tno = zhuan("tno", request);
        tname = zhuan("tname", request);
        tsex = zhuan("tsex", request);
        tage = zhuan("tage", request);
        teb = zhuan("teb", request);
        tpt = zhuan("tpt", request);
        cno1 = zhuan("cno1", request);
        cno2 = zhuan("cno2", request);
        cno3 = zhuan("cno3", request);
        dno = zhuan("dno", request);
        dname = zhuan("dname", request);
        dmanager = zhuan("dmanager", request);
        cno = zhuan("cno", request);
        cname = zhuan("cname", request);
        cpno = zhuan("cpno", request);
        ccredit = zhuan("ccredit", request);
        grade = zhuan("grade", request);
        username = zhuan("username", request);
        password = zhuan("password", request);
        student = (String) request.getAttribute("student");      //用户，多选框的输入
        teacher = (String) request.getAttribute("teacher");
        course = (String) request.getAttribute("course");
        department = (String) request.getAttribute("department");
        sct = (String) request.getAttribute("sct");
        user = (String) request.getAttribute("user");
    }

    public static String zhuan(String key, HttpServletRequest request){
        //request返回""而不是null，这里补救. String引用传递
        return (request.getParameter(key)==null || request.getParameter(key).length()==0)?null:request.getParameter(key);
    }

    public String[] getParameterArr(HttpServletRequest request, String flag) {
        //返回每个request的传入参数数组，其中有的元素可能为null
        userAdaptor(request);
        getValues(request);
        String[] arr = new String[]{};
        if (QinQiu.STUDENT.equals(flag))     arr = new String[]{sno, sname, ssex, sage, sdept};
        if (QinQiu.TEACHER.equals(flag))     arr = new String[]{tno, tname, tsex, tage, teb, tpt, cno1, cno2, cno3};
        if (QinQiu.COURSE.equals(flag))      arr = new String[]{cno, cname, cpno, ccredit};
        if (QinQiu.DEPARTMENT.equals(flag))  arr = new String[]{dno, dname, dmanager};
        if (QinQiu.SCT.equals(flag))         arr = new String[]{sno, cno, tno, grade, (sno==null&&cno==null&&tno==null)?null:(sno+cno+tno)};
        if (QinQiu.USER.equals(flag))        arr = new String[]{username, password, student, teacher, course, department, sct, user};
        if (QinQiu.USER.equals(flag)){
            for (int i=0; i<2 ;i++)
                if (arr[i]!=null)    isKong = false;   //对于user，只需检验用户名和密码是否为空，权限默认"0"拒绝
        } else {
            for (int i=0; i<arr.length ; i++) {
                System.out.println(""+i+": " + (arr[i]==null));
                if (arr[i] != null) isKong = false;
            }
        }
        return arr;
    }

    public boolean isKong() {
        return isKong;
    }

    public static String getZhuJian(String flag){
        //获取指定类型的主键
        String key = "";
        if (flag.equals(QinQiu.STUDENT))        key = "sno";
        if (flag.equals(QinQiu.TEACHER))        key = "tno";
        if (flag.equals(QinQiu.DEPARTMENT))     key = "dname";
        if (flag.equals(QinQiu.COURSE))         key = "cno";
        if (flag.equals(QinQiu.SCT))            key = "xvhao";
        if (flag.equals(QinQiu.USER))           key = "username";
        return key;
    }

    public static String[] getLieMin(String flag){
        //传入类别，返回他的列名数组
        String[] lieMin = null;
        if (flag.equals(QinQiu.STUDENT))     lieMin = new String[]{"学号", "姓名", "性别", "年龄", "系别"};
        if (flag.equals(QinQiu.TEACHER))     lieMin = new String[]{"教工号", "姓名", "性别", "年龄", "学历", "职称", "主讲课程1", "主讲课程2", "主讲课程3"};
        if (flag.equals(QinQiu.DEPARTMENT))  lieMin = new String[]{"系编号", "系名", "系主任"};
        if (flag.equals(QinQiu.COURSE))      lieMin = new String[]{"课程号", "课程名", "先修课程号", "学分"};
        if (flag.equals(QinQiu.SCT))         lieMin = new String[]{"学号", "课程号", "教工号", "成绩", "隐藏"};
        if (flag.equals("sctbao"))           lieMin = new String[]{"学号", "课程号", "教工号", "成绩", "隐藏", "学生名", "课程名", "教师名"};
        return lieMin;
    }

    public static int getZhujianIndex(String flag){
        //返回类型主键在数组中的位置
        if (flag.equals(QinQiu.STUDENT))     return 0;
        if (flag.equals(QinQiu.TEACHER))     return 0;
        if (flag.equals(QinQiu.DEPARTMENT))  return 1;
        if (flag.equals(QinQiu.COURSE))      return 0;
        if (flag.equals(QinQiu.SCT))         return 4;
        if (flag.equals(QinQiu.USER))        return 0;
        return 0;
    }

    public static String getBaoMin(String flag){
        //返回报表的大标题
        if (flag.equals(QinQiu.STUDENT))      return "学生信息报表";
        if (flag.equals(QinQiu.TEACHER))      return "教师信息报表";
        if (flag.equals(QinQiu.TEACHER))      return "院系信息报表";
        if (flag.equals(QinQiu.COURSE))       return "课程信息报表";
        if (flag.equals(QinQiu.SCT))          return "选课信息报表";
        if (flag.equals(QinQiu.USER))         return "用户信息报表";
        return null;
    }

    private void userAdaptor(HttpServletRequest request){
        //用户表传入的是尴尬的check数组，用该方法实现通用适配.
        String student = "";
        String teacher = "";
        String course = "";
        String department = "";
        String sct = "";
        String user = "";
        if (request.getParameterValues(QinQiu.STUDENT)!=null)    for (String value : request.getParameterValues(QinQiu.STUDENT))      student += value;
        if (request.getParameterValues(QinQiu.TEACHER)!=null)    for (String value : request.getParameterValues(QinQiu.TEACHER))      teacher += value;
        if (request.getParameterValues(QinQiu.COURSE)!=null)     for (String value : request.getParameterValues(QinQiu.COURSE))       course += value;
        if (request.getParameterValues(QinQiu.DEPARTMENT)!=null) for (String value : request.getParameterValues(QinQiu.DEPARTMENT))   department += value;
        if (request.getParameterValues(QinQiu.SCT)!=null)        for (String value : request.getParameterValues(QinQiu.SCT))          sct += value;
        if (request.getParameterValues(QinQiu.USER)!=null)       for (String value : request.getParameterValues(QinQiu.USER))         user += value;
        request.setAttribute(QinQiu.STUDENT, (student.length()!=0)?student:"0");
        request.setAttribute(QinQiu.TEACHER, (teacher.length()!=0)?teacher:"0");
        request.setAttribute(QinQiu.COURSE, (course.length()!=0)?course:"0");
        request.setAttribute(QinQiu.DEPARTMENT, (department.length()!=0)?department:"0");
        request.setAttribute(QinQiu.SCT, (sct.length()!=0)?sct:"0");
        request.setAttribute(QinQiu.USER, (user.length()!=0)?user:"0");
    }

    public static void getUerEdit(ResultSet resultSet, HttpServletRequest request) throws Exception{
        //编辑操蛋的用户页面，日了狗的复选框的初始赋值
        int index = 1;
        for (int i = 0; i<SIXBIAO.length; i++){
            String power = resultSet.getString(SIXBIAO[i]);
            request.setAttribute("n"+(index++), (power.contains("1"))?"checked=\"checked\"":"");
            request.setAttribute("n"+(index++), (power.contains("2"))?"checked=\"checked\"":"");
            request.setAttribute("n"+(index++), (power.contains("3"))?"checked=\"checked\"":"");
        }
    }

    public static void setUserPower(ResultSet resultSet, HttpSession session) throws Exception{
        //设置访问权限，seeion中的editPower格式可能为"student,sct,teacher"
        resultSet.next();
        String edit="", bao="", show="";
        for (String biao:SIXBIAO){
            String power = resultSet.getString(biao);
            if (power.contains("1"))    show += biao+",";
            if (power.contains("2"))    bao  += biao+",";
            if (power.contains("3"))    edit += biao+",";
        }
        session.setAttribute("editPower", edit);//3
        session.setAttribute("baoPower", bao);//2
        session.setAttribute("showPower", show);//1
    }

}



