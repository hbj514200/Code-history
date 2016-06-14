import java.io.*;                                                           //数据流包
import java.net.*;                                                          //网络包
class main {                                                                //主类
 private BufferedReader reader;                                             //创建一个缓存读取流BufferReader
 private ServerSocket server;                                               //创建一个服务器套字对象ServerSocket
 private Socket socket;                                                     //创建一个套字对象socket
   
 void getserver(){                                                         //使用getSever()方法启动服务器的运作
     try {                                                                 //网络操作有风险try
         server=new ServerSocket(8998);        System.out.println("舍长服务器的连接套字创建成功！");  //把ServerSocket对象实例化，分配8898端口
         while(true){                                                                             //无限循环
             System.out.println("正在等待光赐的客户端连接…………");     socket=server.accept();         //利用ServerSocket服务器套字对象的accept()方法返回一个链接套字，此处使用socket来承接。
             reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));           //定义一个缓存读取流BufferReader，传入的是一个读取器，再传入的是一个由socket套字对象的getInputSteam()返回的基础读取流
             getClienMessage();                                                                   //调用下面的自定义方法获取信息
         }
     } catch (Exception e) {       System.out.println("代码第16行报错!");                          //异常显示代码
     }
}               //使用getSever()方法启动服务器的运作

 private void getClienMessage() {                                                                //获取客户端发来信息的方法
     try                   {   while(true)   System.out.println("光赐的客户机： "+reader.readLine());    }  //使用了无限循环，使用reader的readline()方法获取从客户端传来的字符串
     catch (Exception e)   {   System.out.println("代码第22行报错");    }                                   //显示异常
     try                   {      if(reader!=null)   reader.close();      if(socket!=null)   socket.close();      }   //关闭流和套字
     catch (Exception e)   {   System.out.println("代码第24行报错");    }                                   //显示异常
 }

public static void main(String[] args) {                  //主main测试函数
main tcp=new main();                                      //实例化本类
tcp.getserver();                                          //启动服务器
}
 
}

//小祥服务器代码
//使用类里面的全局变量很方便，每个方法都可以自由地操作它， 估计也是Java的初衷