package servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class downCSV extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        del();
        List<String> data = setToList((String) request.getSession().getAttribute("outputCSV"));
        request.getSession().removeAttribute("outputCSV");
        if (data==null || "".equals(data)){
            response.getWriter().printf("下载请求非法！");
        } else {
            String name = "../webapps/Example/download/" + Math.abs(new Random().nextLong()) + ".csv";
            System.out.println("hahahaha:"+exportCsv(new File(name), data));
            xiazai(response, name);
        }
    }

    private void xiazai(HttpServletResponse response, String uri) throws ServletException, IOException {
        File f = new File(uri);
        if(f.exists()){
            FileInputStream fis = new FileInputStream(f);
            String filename = URLEncoder.encode(f.getName(),"utf-8"); //解决中文文件名下载后乱码的问题
            byte[] b = new byte[fis.available()];
            fis.read(b);
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition","attachment; filename="+filename+"");
            response.setContentType("application/vnd.ms-excel");
            //获取响应报文输出流对象
            ServletOutputStream out =response.getOutputStream();
            //输出
            out.write(b);
            out.flush();
            out.close();
        }
    }
    private boolean exportCsv(File file, List<String> dataList){
        boolean isSucess=false;

        FileOutputStream out=null;
        OutputStreamWriter osw=null;
        BufferedWriter bw=null;
        try {
            out = new FileOutputStream(file);
            osw = new OutputStreamWriter(out, "GBK");
            bw =new BufferedWriter(osw);
            if(dataList!=null && !dataList.isEmpty()){
                for(String data : dataList){
                    bw.append(data).append("\r");
                }
            }
            isSucess=true;
        } catch (Exception e) {
            isSucess=false;
        }finally{
            if(bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(osw!=null){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return isSucess;
    }
    private void del(){
        //删除不必要的旧下载文件
        File dir = new File("../webapps/Example/download/");
        if (!dir.exists() || dir.listFiles()==null)  return;
        for (File file : dir.listFiles())     file.delete();
    }

    private List<String> setToList(String htmlTable){
        //将输入的报表html表格代码转为CSV需要的格式
        htmlTable = htmlTable.replaceAll("<table(.*?)>", "");
        htmlTable = htmlTable.replaceAll("<tr><td(.*?)>", "");
        htmlTable = htmlTable.replaceAll("</td></tr>", "");
        htmlTable = htmlTable.replaceAll("<tr><th(.*?)>", "");
        htmlTable = htmlTable.replaceAll("</th><th(.*?)>", ",");
        htmlTable = htmlTable.replaceAll("</th(.*?)></tr>", "\n");
        htmlTable = htmlTable.replaceAll("<tbody>", "");
        htmlTable = htmlTable.replaceAll("</tody>", "");
        htmlTable = htmlTable.replaceAll("<thead>", "");
        htmlTable = htmlTable.replaceAll("</thead>", "");
        htmlTable = htmlTable.replaceAll("</td><td(.*?)>", ",");
        htmlTable = htmlTable.replaceAll("</tbody></table>", "");
        return Arrays.asList( htmlTable.split("\n") );
    }

}