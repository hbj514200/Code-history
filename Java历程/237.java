import java.awt.*;
import javax.swing.*;

class main extends JFrame {

public main() {
Container c=getContentPane();                           //��ȡ�����ҾͲ�˵��
setLayout(new GridLayout(7,3,5,5));                     //7��3�е����� ���������Ǽ�ࡣ
for(int i=1; i<=20; i++)  {    c.add(new JButton("��ť "+i));    }
setSize(450,450);
setTitle("���񲼾ֹ���������ʵ��");
setVisible(true);
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}

public static void main(String[] arg)   {   new main();  }

}