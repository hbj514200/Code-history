import java.awt.*;
import javax.swing.*;
class main extends JFrame {                                      //���Ǽ̳�JFrame

public main() { 
Container c=getContentPane();                                    //��ȡһ������������Ӧ���Ƕ����JFrame����
setLayout(new GridLayout(2,2,3,3));                              //����Ϊ���������
JRadioButton jr1=new JRadioButton();                             //����1�ŵ�ѡ��JRadioButton
JRadioButton jr2=new JRadioButton();                             //����2�ŵ�ѡ��JRadioButton
JRadioButton jr3=new JRadioButton();                             //����3�ŵ�ѡ��JRadioButton
JRadioButton jr4=new JRadioButton();                             //����4�ŵ�ѡ��JRadioButton
c.add(jr1);   c.add(jr1);   c.add(jr1);   c.add(jr4);            //���ĸ���ѡ���������
setVisible(true);                                                //���ô���ɼ�
setSize(320,480);                                                //�����������С
setTitle("��ѡ����ʵ�鴰��");
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);         //���ùرմ���ʱ��������
}

public static void main(String[] arg)   {  new main();  }        //���������½������main����

}
