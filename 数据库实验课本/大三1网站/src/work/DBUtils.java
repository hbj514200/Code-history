package work;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;

public class DBUtils {
    private static Connection connection = null;

    private static void init(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?user=root&password=&characterEncoding=utf8");
        } catch (Exception e){
            System.out.println("xiaoxiang: connect database error, init error");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (connection==null)    init();
        return connection;
    }

    public static int getCount(String biao) {
        //获取某个表的总行数，分页用
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery("SELECT COUNT(*) AS shu FROM " + biao);
            resultSet.next();
            return Integer.parseInt(resultSet.getString("shu"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void delete(HttpServletRequest request, JspWriter out, String flag){
        //删除表中数据
        String delNo = request.getParameter("delNo");
        if (delNo!=null){
            try {
                DBUtils.getConnection().createStatement().execute("DELETE FROM "+flag+" WHERE "+QinQiu.getZhuJian(flag)+" = '"+delNo+"'");
                out.println("<script language=\"JavaScript\">\n" + "    alert(\"删除成功!\");\n" + "</script>");
            } catch (Exception e){
                try {
                    out.println("<script language=\"JavaScript\">\n" + "    alert(\"删除失败，请检查操作合法性!\");\n" + "</script>");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            }
        }
    }

    public static void insert(String[] arr, JspWriter out, String flag, boolean delOld){
        //在数据表中插入一行数据, delOld为是否删除旧数据（更新）
        try {
            PreparedStatement ps = null;
            if (QinQiu.STUDENT.equals(flag))    ps = DBUtils.getConnection().prepareStatement("INSERT INTO student VALUES (?,?,?,?,?)");
            if (QinQiu.TEACHER.equals(flag))    ps = DBUtils.getConnection().prepareStatement("INSERT INTO teacher VALUES (?,?,?,?,?,?,?,?,?)");
            if (QinQiu.DEPARTMENT.equals(flag)) ps = DBUtils.getConnection().prepareStatement("INSERT INTO department VALUES (?,?,?)");
            if (QinQiu.COURSE.equals(flag))     ps = DBUtils.getConnection().prepareStatement("INSERT INTO course VALUES (?,?,?,?)");
            if (QinQiu.SCT.equals(flag))        ps = DBUtils.getConnection().prepareStatement("INSERT INTO sct VALUES (?,?,?,?,?)");
            if (QinQiu.USER.equals(flag))       ps = DBUtils.getConnection().prepareStatement("INSERT INTO user VALUES (?,?,?,?,?,?,?,?)");
            if (ps==null){
                out.println("<script language=\"JavaScript\">alert(\"录入失败，系统无法连接数据库\");</script>");
                return;
            }
            Connection conn = DBUtils.getConnection();
            try {
                conn.setAutoCommit(false);
                if (delOld){
                    System.out.println("DELETE FROM "+flag+" WHERE "+QinQiu.getZhuJian(flag)+" = '"+arr[QinQiu.getZhujianIndex(flag)]+"'");
                    ps.execute("DELETE FROM "+flag+" WHERE "+QinQiu.getZhuJian(flag)+" = '"+arr[QinQiu.getZhujianIndex(flag)]+"'");
                }
                for (int i=1; i<=arr.length; i++)       ps.setString(i, arr[i-1]);
                System.out.println(ps.toString());
                ps.executeUpdate();
                conn.commit();
                out.println("<script language=\"JavaScript\">alert(\"处理成功！\");</script>");
            } catch (Exception e){
                out.println("<script language=\"JavaScript\">alert(\"添加失败, 请检查输入！\");</script>");
                out.println("<script language=\"JavaScript\">window.history.go(-1)</script>");
                conn.rollback();
                e.printStackTrace();
            }
            conn.setAutoCommit(true);
        } catch (Exception e){e.printStackTrace();}
    }

    public static ResultSet quuery(String sql) {
        //执行输入的SQL查询语句
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            return resultSet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet showQuuery(String flag, String pei){
        //返回浏览模块的查找搜索结果, 全表模糊搜索, 暂不查找用户表
        String tiao = "kong";
        if (QinQiu.STUDENT.equals(flag))    tiao = " where sno LIKE ~ or sname LIKE ~ or ssex LIKE ~ or sage LIKE ~ or sdept LIKE ~";
        if (QinQiu.TEACHER.equals(flag))    tiao = " where tno LIKE ~ or tname LIKE ~ or tsex LIKE ~ or tage LIKE ~ or teb LIKE ~ or tpt LIKE ~ or cno1 LIKE ~ or cno2 LIKE ~ or cno3 LIKE ~";
        if (QinQiu.DEPARTMENT.equals(flag)) tiao = " where dno LIKE ~ or dname LIKE ~ or dmanager LIKE ~";
        if (QinQiu.COURSE.equals(flag))     tiao = " where cno LIKE ~ or cname LIKE ~ or cpno LIKE ~ or ccredit LIKE ~";
        if (QinQiu.SCT.equals(flag))        tiao = " where sno LIKE ~ or cno LIKE ~ or tno LIKE ~ or grade LIKE ~";
        pei = "'%"+pei+"%'";
        try {
            return DBUtils.getConnection().createStatement().executeQuery("SELECT * FROM "+ flag + tiao.replaceAll("~", pei));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
