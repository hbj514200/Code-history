import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class main extends JFrame implements ActionListener {                        //实现了ActionListener的接口
private JButton jb=new JButton("请你点击我");                                 //创建一个带文字的按钮jb

public main(){
Container cp=getContentPane();                                               //获取一个界面容器
setLayout(new FlowLayout());                                                 //启用自动界面管理器
jb.setBounds(30,20,10,10);                                                   //设置按钮jb的大小
cp.add(jb);                                                                  //把jb按钮加入界面容器
setSize(420,240);     setVisible(true);    setTitle("不使用内部类的监听事件"); //基本主窗口设置
jb.addActionListener(this);                                                  //按钮jb加入监听动作事件，实现了接口的this本类！
}

public void actionPerformed(ActionEvent e)  {   jb.setText("我被点击了");   } //实现接口中必须覆盖的方法，动作事件

public static void main(String[] arg)      {   new main();   }               //主main测试函数

}