import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class main extends JFrame {

public main() {  
Container cp=getContentPane();                                       //��ȡ��������
cp.setLayout(new FlowLayout());
JTextField jt1=new JTextField("�������ı���",10);                     //����һ�������ֵ��ı���jt1
JTextField jt2=new JTextField("�뵥����",10);                        //����һ�������ֵ��ı���jt2
cp.add(jt1);    cp.add(jt2);                                        //���������ֿ�����������
setVisible(true);   setSize(320,240);                               //�����ڵĻ�������
class jiaodian implements FocusListener {                           //����һ����������¼�(�ڲ���)ʵ��FocusListener�ӿڡ�
public void focusGained(FocusEvent e)  {                                                         }   //�̶��������õ�����ʱ�� 
public void focusLost(FocusEvent e)    {  JOptionPane.showMessageDialog(null, "�ı���ʧȥ����");   }  //�̶�������ʧȥ����ʱ
}
jt1.addFocusListener(new jiaodian());                              //Ϊjt1�ı�����ӽ���ʱ�������
}

public static void main(String[] arg)     {   new main();    }     //��main���Է���

}