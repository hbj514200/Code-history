import java.awt.*;
import javax.swing.*;
class main extends JFrame {                                   //主类继承JFrame成为窗口

public main(){
setSize(320,240);                                             //设置主窗体大小
setTitle("自动换行的文本框测试窗口");                         //设置主窗口的标题名字
setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);   //设置关闭窗口时什么也不干
Container cp=getContentPane();                                //创建一个界面容器
JTextArea jt=new JTextArea("文本框",6,6);                     //创建一个文本框，设定了默认内容和大小
jt.setLineWrap(true);                                         //设置本文本框自动换行
cp.add(jt);                                                   //把文本框加入界面容器
setVisible(true);                                             //设置主窗口为可见
}

public static void main(String[] arg)    {    new main();    }//主main测试函数

}