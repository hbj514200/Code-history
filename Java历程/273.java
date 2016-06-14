import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
class main extends JFrame {                                     //主JFrame类
JTextArea wenzi=new JTextArea(15,40);                           //创建一个文本编辑框，传入面积大小
   
public main(){                                                  //主窗口函数
Container cp=getContentPane();                                  //获取一个界面容器
cp.setLayout(new FlowLayout());                                 //自由布局管理器管理界面
JButton jb1=new JButton("写入文件");    JButton jb2=new JButton("读取文件");   jb1.setBounds(10,10,10,10);    jb2.setBounds(10,10,10,10);  jb1.addActionListener(new xieru());    jb2.addActionListener(new duqu());  //创建两个按钮，设定大小和动作监听事件
cp.add(wenzi);      cp.add(jb1);       cp.add(jb2);             //把所有组件按顺序加入界面容器
setVisible(true);   setSize(460,340);   setTitle("小祥文字编辑系统");   setResizable(false);   setDefaultCloseOperation(EXIT_ON_CLOSE);     //对主窗口做基本的设置
}

class xieru implements ActionListener {                        //写入按钮动作事件
public void actionPerformed(ActionEvent e){                    //Actionlister接口固定响应函数
File file=new File("word.txt");                                //创建一个文件对象
try{                                                           //文件操作有风险try
FileWriter out=new FileWriter(file);                           //创建一个FileWriter写入对象
String s=wenzi.getText();                                      //获取文本框中的文字
out.write(s);      out.close();                                //向文本写入文字， 关闭流
}catch(IOException a)  {  System.out.println("文件不存在，已创建");   }  //抛出异常的响应
}
}

class duqu implements ActionListener {                          //读取按钮动作事件
public void actionPerformed(ActionEvent e){                     //Actionlister接口固定响应函数
File file=new File("word.txt");                                 //创建一个文件对象
try{                                                            //文件操作有风险try
FileReader in=new FileReader(file);                             //创建一个FileReader读取对象
char byt[]=new char[1024];                                      //创建一个字符数组
int len=in.read(byt);                                           //读取到byt数组，统计记录长度
wenzi.setText(new String(byt,0,len));                           //转化为字符串，同时显示在文本框中
}catch(Exception a)  {  System.out.println("文件不存在，已创建");   }   //抛出异常的响应
}
}

public static void main(String[] args)    {  new main();   }       //主main测试函数

}

//程序可以换行，但是在txt中并没有换行，但是读取时依然带有换行
