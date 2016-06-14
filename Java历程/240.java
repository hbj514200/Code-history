import java.awt.*;
import javax.swing.*;  
class main extends JFrame {                      //又是继承JFrame类的。

public main() {
Container c=getContentPane();                    //获取界面容器
JTextArea ta=new JTextArea(20,50);               //创建一个JTextArea打字区域ta。
JScrollPane sp=new JScrollPane(ta);              //创建带滚动条的JScrollPane面板，创建时直接把ta加入。
c.add(sp);                                       //把JScrollPane面板sp加入到界面容器中。
setTitle("带滚动条的文字编辑器");                //设置主窗口的标题名字。
setVisible(true);                                //显示本窗口
setSize(480,320);                                //调整本窗口的大小
setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);          //应该是设置为关闭窗口时什么也不干。
}

public static void main(String[] arg)  {  new main();  }

}