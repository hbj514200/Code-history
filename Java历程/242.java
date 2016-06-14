import java.awt.*;
import javax.swing.*;
class main extends JFrame {                                      //又是继承JFrame

public main() { 
Container c=getContentPane();                                    //获取一个界面容器，应该是对这个JFrame负责。
setLayout(new GridLayout(2,2,3,3));                              //设置为网格管理器
JRadioButton jr1=new JRadioButton();                             //创建1号单选框JRadioButton
JRadioButton jr2=new JRadioButton();                             //创建2号单选框JRadioButton
JRadioButton jr3=new JRadioButton();                             //创建3号单选框JRadioButton
JRadioButton jr4=new JRadioButton();                             //创建4号单选框JRadioButton
c.add(jr1);   c.add(jr1);   c.add(jr1);   c.add(jr4);            //把四个单选框加入容器
setVisible(true);                                                //设置窗体可见
setSize(320,480);                                                //设置主窗体大小
setTitle("单选框是实验窗口");
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);         //设置关闭窗口时结束进程
}

public static void main(String[] arg)   {  new main();  }        //主函数，新建本类的main方法

}
