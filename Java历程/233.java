import java.awt.*;
import javax.swing.*;

class main extends JFrame {

public main(){
setTitle("�������������յİ�ť");                     //���ô��ڵı���
setLayout(null);                                    //ȡ�����ֹ������Ĺ���
setBounds(0,0,500,250);                             //���ڵ�λ�úʹ�С
Container c=getContentPane();                       //��ȡһ������
JButton b1=new JButton("��ť1");                    //����һ�Ű�ť
JButton b2=new JButton("��ť2");                    //�������Ű�ť
b1.setBounds(10,30,80,30);      b2.setBounds(60,70,100,20);      //������ť��λ�úʹ�С	                   
c.add(b1);                       c.add(b2);                      //�Ѱ�ť��������
setVisible(true);
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}

public static void main(String[] arg){
new main();
}

}