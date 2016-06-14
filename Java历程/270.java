import java.io.*;                               //这是处理文件或数据流的必备包！！  io
class main {

public static void main(String[] arg){                          //主main测试函数
File file=new File("word.txt");                                //创建一个File文件对象，传入文件实际地址
if( file.exists() )     {   file.delete();         System.out.println("文件已删除");  }  //用文件对象的delete方法删除文件
else try                {   file.createNewFile();  System.out.println("文件已创建");  }  //createNewFile方法可以创建本文件
     catch(Exception e) {   e.printStackTrace();                                     }  //显示异常的详细信息
}

}

//有许多文件操作部分是会有异常风险的，所以try catch用得比较多，还有文件自带的createNewFile和delete方法也好