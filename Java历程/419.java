import java.awt.*;                                                              //�����
import java.awt.event.*;
import javax.swing.*;

public class main extends JFrame {
 JLabel label=new JLabel();
 JPopupMenu popupMenu = new JPopupMenu();                                       // ��������ʽ�˵����� JPopupMenu
 
public static void main(String args[]){                                         //��main���Է���
    new main().setVisible(true);
}
	
	public main() {                                                         //���췽��
		setTitle("����ʽ�˵�����");                                        //��������Ϊ����������������
		setBounds(600, 300, 500, 375);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		label.setText("                ���ڴ����е�������Ҽ���");         //Ϊ�ײ��ǩ label ��������
		getContentPane().add(label, BorderLayout.CENTER);                //�����ֱ�ǩ label ���뵽�������� �м�
		
		getContentPane().addMouseListener(new MouseAdapter() {     	// Ϊ����Ķ��������������¼�������
                    public void mouseReleased(MouseEvent e) {                    // ��갴�����ͷ�ʱ�����÷��� mouseReleased
                        if (e.isPopupTrigger())                                     // �жϴ˴�����¼��Ƿ�Ϊ������ĵ����˵������¼� ���� isPopupTigger
                            popupMenu.show(e.getComponent(), e.getX(), e.getY());   // ����������ͷ�����λ�õ����˵�
			}
		});
		
		JMenuItem cutItem = new JMenuItem("����");                       //�½�һ���˵��Ӷ��� �����С���
		cutItem.addActionListener(new ItemListener());                      //��Ӳ˵���� ��Ӧ�¼����Զ���ģ�
		popupMenu.add(cutItem);                                             //�������뵽�˵�һ�������
		
		JMenuItem copyItem = new JMenuItem("����");                      //�½�һ���˵��Ӷ��� �����ơ���
		copyItem.addActionListener(new ItemListener());                     //��Ӳ˵���� ��Ӧ�¼����Զ���ģ�     
		popupMenu.add(copyItem);                                            //�������뵽�˵�һ�������
		
		JMenuItem pastItem = new JMenuItem("ճ��");                      //�½�һ���˵��Ӷ��� ��ճ������
		pastItem.addActionListener(new ItemListener());                     //��Ӳ˵���� ��Ӧ�¼����Զ���ģ�
		popupMenu.add(pastItem);                                            //�������뵽�˵�һ�������
		
		JMenu editMenu = new JMenu("�༭");                              //�½�һ���˵������ ���༭����  ���˵������
		popupMenu.add(editMenu);                                            //�������뵽�˵�һ�������
		
		JMenuItem readItem = new JMenuItem("ֻ��");                         //�½�һ���˵��Ӷ��� ��ֻ������
		readItem.addActionListener(new ItemListener());                         //��Ӳ˵���� ��Ӧ�¼����Զ���ģ�
		editMenu.add(readItem);                                                 //�������롰�༭���˵���
		
		JMenuItem writeItem = new JMenuItem("��д");                        //�½�һ���˵��Ӷ��� ����д����
		writeItem.addActionListener(new ItemListener());                        //��Ӳ˵���� ��Ӧ�¼����Զ���ģ�
		editMenu.add(writeItem);                                                //�������롰�༭���˵���
		
		JMenu fontMenu = new JMenu("����");                                 //�½�һ���˵������ �����塱�����˵������
		editMenu.add(fontMenu);                                                 //�������뵽�˵�һ�������
		
		JMenuItem boldfacedItem = new JMenuItem("�Ӵ�");                    //�½�һ���˵��Ӷ��� ���Ӵ֡���
		boldfacedItem.addActionListener(new ItemListener());                    //��Ӳ˵���� ��Ӧ�¼����Զ���ģ�
		fontMenu.add(boldfacedItem);                                            //�������뵽����˵��������
		
		JMenuItem italicItem = new JMenuItem("б��");                       //�½�һ���˵��Ӷ��� ��б�塱��
		italicItem.addActionListener(new ItemListener());                        //��Ӳ˵���� ��Ӧ�¼����Զ���ģ�
		fontMenu.add(italicItem);                                                //�������뵽����˵��������
	}
	
    private class ItemListener implements ActionListener {                      //�Զ���Ķ����¼��� �̳�ActionListener
        public void actionPerformed(ActionEvent e) {                             //�̶���Ӧ��������
            JMenuItem menuItem = (JMenuItem) e.getSource();                             //��ȡר��Դ����
            System.out.println("���������ǲ˵��" + menuItem.getText());                //��� getText
		}
	}
	
}

//Ŀǰ������������Button��ť��ActionEvent��MouseEvent������ò��һ���ǵ������һ�����Բ�׽��궯��
//������Ӧһ���Ķ����¼��� �Զ���һ����̳�ActionListener���� ������getSource����������