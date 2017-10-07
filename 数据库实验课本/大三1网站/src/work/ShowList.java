package work;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ShowList {

    public static String getListHtml(ResultSet resultSet, String[] min) {
        //负责浏览模块的表格绘制
        try {
            StringBuilder result = new StringBuilder("<table style=\"box-shadow: 0 0 18px #aaa; margin:0 auto; width:75%; margin-Top: 40px; margin-bottom:50px\">");
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int count = rsmd.getColumnCount();

            result.append("<thead><tr>");               //列名
            for(int i=0; i<count; i++){
                if (min.length>=5 && min[4].equals("隐藏") && i==4)    continue;
                result.append("<th style=\"text-align: center\">" + min[i] + "</th>");
            }
            result.append("</tr></thead><tbody>");

            while (resultSet.next()){            //内容
                result.append("<tr>");
                for(int i=1; i<=count; i++)
                    if (i==5 && min[4].equals("隐藏"))    continue;
                    else if (resultSet.getString(rsmd.getColumnName(i))==null)  result.append("<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>");
                    else                                  result.append("<td style=\"text-align: center\">" + resultSet.getString(rsmd.getColumnName(i)) + "</td>");
                result.append("</tr>\n");
            }
            result.append("</tbody></table>");
            return result.toString();
        } catch (Exception e){
            e.printStackTrace();
        }
        return "系统错误，无法显示表格";
    }

    public static String getListBianJi(ResultSet resultSet, String[] min, String flag, int nowPage) {
        //负责编辑列表模块的表格绘制
        try {
            StringBuilder result = new StringBuilder("<table style=\"box-shadow: 0 0 18px #aaa; margin:0 auto; width:75%; margin-Top: 40px; margin-bottom:50px\">");
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int count = rsmd.getColumnCount();

            result.append("<thead><tr>");               //列名
            for(int i=0; i<=count; i++){
                if (flag.equals(QinQiu.SCT) && i==4)    continue;  //选课隐藏列xvhao不显示
                if (flag.equals(QinQiu.USER) && i==1)   continue;  //用户密码列password不显示
                result.append("<th style=\"text-align: center\">" + min[i] + "</th>");
            }
            result.append("</tr></thead><tbody>");

            int zhujian = QinQiu.getZhujianIndex(flag)+1;    //主键名字,rsmd貌似从一开始
            while (resultSet.next()){            //内容
                result.append("<tr>");
                for(int i=1; i<=count; i++)
                    if (flag.equals(QinQiu.SCT) && i==5)           continue;
                    else if (flag.equals(QinQiu.USER) && i==2)     continue;
                    else if (resultSet.getString(rsmd.getColumnName(i))==null)  result.append("<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>");
                    else                                  result.append("<td style=\"text-align: center\">" + resultSet.getString(rsmd.getColumnName(i)) + "</td>");
                result.append("<td style=\"text-align: center\"><a href=\"addData.jsp?edit=a&flag="+flag+"&no="+resultSet.getString(rsmd.getColumnName(zhujian))+"\" style=\"color:blue\">编辑</a>&nbsp;&nbsp;&nbsp;&nbsp;");
                result.append("<a href=\"editAll.jsp?flag="+flag +"&nowPage="+nowPage+"&delNo="+resultSet.getString(rsmd.getColumnName(zhujian))+"\" style=\"color:blue\">删除</a></td>");
                result.append("</tr>");
            }
            result.append("</tbody></table>");
            return result.toString();
        } catch (Exception e){
            e.printStackTrace();
        }
        return "系统错误，无法显示表格";
    }

}
