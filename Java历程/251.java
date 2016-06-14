import java.awt.*;                                     
import javax.swing.*;
import java.awt.event.*;
class main extends JFrame {                                    //主窗口继承JFrame成为窗口
private JButton jb=new JButton("舍长帅不帅的答案");            //创建一个成员静态的按钮jb。
   
public main(){                                                //主类      
Container cp=getContentPane();                                //获取一个界面容器
setSize(550,320);   setTitle("内部类事件对象测试窗口");   setVisible(true);
setLayout(null);                                              //设置不要界面管理器干预
cp.add(jb);                                                   //把jb按钮加入界面容器
jb.setBounds(10,10,150,40);                                   //设置jb按钮大小
jb.addActionListener(new jbAction());                         //为jb添加被点击事件处理监听
}
  
class jbAction implements ActionListener {                    //自定义一个事件类型
public void actionPerformed(ActionEvent e)   {   jb.setText("当然帅啦");   }   //内容，按钮jb的反应
}

public static void main(String[] arg)   {   new main();  }    //主main测试函数

}