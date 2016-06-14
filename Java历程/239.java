import java.awt.*;
import javax.swing.*;
class main extends JFrame {

public main() {
Container c=getContentPane();                               //获取界面容器
c.setLayout(new GridLayout(2,1,10,10));                     //设置容器为2行1列的网格布局
JPanel p1=new JPanel(new GridLayout(1,3,10,10));            //初始化面板为1行3列的网格布局
JPanel p2=new JPanel(new GridLayout(1,2,10,10));
JPanel p3=new JPanel(new GridLayout(1,3,10,10));
JPanel p4=new JPanel(new GridLayout(1,3,10,10));
p1.add(new JButton("1"));    p2.add(new JButton("2"));   p3.add(new JButton("3"));   p4.add(new JButton("4"));  p4.add(new JButton("5"));
c.add(p1);  c.add(p2);  c.add(p3);  c.add(p4);
setSize(600,300);
setVisible(true);
}

public static void main(String[] arg)  {   new main();  }

}