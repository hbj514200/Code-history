import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class main extends JFrame {
JMenuBar menuBar=new JMenuBar();                                                //�½�һ�� �˵������� JMenuBar ��Bar���ʣ� �� ��  ��
JMenu menu=new JMenu("�˵�������");                                              //�½�һ�� �˵������ JMenu    ��ֱ����ʾ�ڲ˵����ϣ�
JMenuItem menuItem=new JMenuItem("�˵�������");                                  //�½�һ�� �˵��Ӷ��� MenuItem �����ڼӵ������˵�  ��
JMenuItem menuItem2=new JMenuItem("�˵�������2");                                //�½�һ�� �˵��Ӷ��� MenuItem �����ڼӵ������˵�  ��

public static void main(String[] args) {                                        //��main���Է���
   new main().setVisible(true);
}

public main(){
    Container cp=getContentPane();                                              //�������У�  �����������Ե�����
    setSize(320,240);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("�˵�������");
    
    setJMenuBar(menuBar);                                                       //ʹ�� setJMenuBar() ����Ϊ�������ò˵�������
    menuBar.add(menu);                                                          //�Ѳ˵��� JMenu ���뵽�˵�����
    menu.add(menuItem);                                                         //�Ѳ˵��Ӷ��� JMenuItem ���뵽�˵�����
    menu.add(menuItem2);                                                        //�Ѳ˵��Ӷ��� JMenuItem ���뵽 JMenu ��
    
    menuItem.addActionListener(new ActionListener() {                           //Ϊ menuItem1 �˵��Ӷ�����Ӷ�����Ӧ�¼�
        public void actionPerformed(ActionEvent e) {                                //�̶���Ӧ����������  ��Button�����¼�һ��
            JMenuItem menuItem=(JMenuItem) e.getSource();                               //���� getSource() ������ȡ�¼���Դ��JMenuItem����
            System.out.println("���������ǲ˵��  "+menuItem.getText());                //��ʾ�û��������
        }
    });
    
     menuItem2.addActionListener(new ActionListener() {                           //Ϊ menuItem1 �˵��Ӷ�����Ӷ�����Ӧ�¼�
        public void actionPerformed(ActionEvent e) {                                //�̶���Ӧ����������  ��Button�����¼�һ��
            JMenuItem menuItem=(JMenuItem) e.getSource();                               //���� getSource() ������ȡ�¼���Դ��JMenuItem����
            System.out.println("���������ǲ˵��  "+menuItem.getText());                //��ʾ�û��������
        }
    });
    
}
    
}