import java.awt.*;
import javax.swing.*;
class main extends JFrame {

public main() {
Container c=getContentPane();                               //��ȡ��������
c.setLayout(new GridLayout(2,1,10,10));                     //��������Ϊ2��1�е����񲼾�
JPanel p1=new JPanel(new GridLayout(1,3,10,10));            //��ʼ�����Ϊ1��3�е����񲼾�
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