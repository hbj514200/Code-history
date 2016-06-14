import javax.swing.*;
import java.awt.*;
import java.net.URL;
import javax.swing.event.*;

class main extends JFrame {
final JTabbedPane tabbedPane=new JTabbedPane();                                 //����һ��ѡ���壬Ĭ���ڴ����ϲ�

    public static void main(String[] args) {
        new main().setVisible(true);
    }

public main(){
    tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);               //ѡ����Ĳ��ֹ���  �����ǹ������
    tabbedPane.addChangeListener(new ChangeListener() {                         //Ϊ��ǩ��Ӷ����¼��� ��Ȼ�Ǹı������  ԭ��Ϊ�ǵ���¼���
        public void stateChanged(ChangeEvent e) {                               //�̶�������״̬�ı��¼�
            int selectedIndex=tabbedPane.getSelectedIndex();                    //����ѡ�����getSelectedIndex��ȡĿǰѡ�����ĸ���ǩ
            String title=tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());  //ѡ�����getTitleAt��ȡ��n���ַ���
            System.out.println(title);                                          //���ѡ���
        }
    });
    
    getContentPane().add(tabbedPane, BorderLayout.CENTER);                      //��ѡ���������������м䣿������
    URL resource=main.class.getResource("tab.jpg");                             //��ȡ��ѡ�ͼ��URL
    ImageIcon imageIcon=new ImageIcon(resource);                                //ʵ����ͼ�����
    JLabel tabJLabelA=new JLabel();                                             //����������JLabel��ǩ
    JLabel tabJLabelB=new JLabel();
    JLabel tabJLabelC=new JLabel();
    
    tabJLabelA.setText("ѡ�A");                                               //�ֱ������������ֱ�ǩ������
    tabbedPane.addTab("ѡ�A", imageIcon, tabJLabelA, "����鿴ѡ�A");        //��ѡ�������ѡ�  ���룺  ѡ������ ѡ��ͼ�꣬ ҳ����������ʾ����
    tabJLabelB.setText("ѡ�B");
    tabbedPane.addTab("ѡ�B", imageIcon, tabJLabelB, "����鿴ѡ�A");
    tabJLabelC.setText("ѡ�C");
    tabbedPane.addTab("ѡ�C", imageIcon, tabJLabelC, "����鿴ѡ�A");
    tabbedPane.setSelectedIndex(2);                                             //����ѡ����
    tabbedPane.setEnabledAt(0, false);                                          //һ��ѡ������ã�   ע����0���ģ�
    
    setSize(320,240);
    setTitle("ѡ�����");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
}


    
}