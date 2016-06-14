import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class main extends JFrame {

public main() {  
Container cp=getContentPane();                                       //获取界面容器
cp.setLayout(new FlowLayout());
JTextField jt1=new JTextField("请其他文本框",10);                     //创建一个带文字的文本框jt1
JTextField jt2=new JTextField("请单击我",10);                        //创建一个带文字的文本框jt2
cp.add(jt1);    cp.add(jt2);                                        //把两个文字框加入界面容器
setVisible(true);   setSize(320,240);                               //主窗口的基本设置
class jiaodian implements FocusListener {                           //创建一个焦点监听事件(内部类)实现FocusListener接口。
public void focusGained(FocusEvent e)  {                                                         }   //固定方法，得到焦点时。 
public void focusLost(FocusEvent e)    {  JOptionPane.showMessageDialog(null, "文本框失去焦点");   }  //固定方法，失去焦点时
}
jt1.addFocusListener(new jiaodian());                              //为jt1文本框添加焦点时间监听。
}

public static void main(String[] arg)     {   new main();    }     //主main测试方法

}