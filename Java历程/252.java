import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class main extends JFrame implements ActionListener {                        //ʵ����ActionListener�Ľӿ�
private JButton jb=new JButton("��������");                                 //����һ�������ֵİ�ťjb

public main(){
Container cp=getContentPane();                                               //��ȡһ����������
setLayout(new FlowLayout());                                                 //�����Զ����������
jb.setBounds(30,20,10,10);                                                   //���ð�ťjb�Ĵ�С
cp.add(jb);                                                                  //��jb��ť�����������
setSize(420,240);     setVisible(true);    setTitle("��ʹ���ڲ���ļ����¼�"); //��������������
jb.addActionListener(this);                                                  //��ťjb������������¼���ʵ���˽ӿڵ�this���࣡
}

public void actionPerformed(ActionEvent e)  {   jb.setText("�ұ������");   } //ʵ�ֽӿ��б��븲�ǵķ����������¼�

public static void main(String[] arg)      {   new main();   }               //��main���Ժ���

}