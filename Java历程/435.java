import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class main extends JFrame {                          
	
 private CardLayout cardLayout=new CardLayout();                                // ��Ƭ���ֹ�����
 private JPanel cardPanel=new JPanel(cardLayout);                               // ���ÿ�Ƭ�Ķ������, ʹ�ÿ�Ƭ���ֹ���
	
    public static void main(String args[]) {
            new main().setVisible(true);
    }
	
    public main() {
    setResizable(false);
    setTitle("ʹ�ÿ�Ƭ���ֹ�����");
    setBounds(100, 100, 600, 100);
    Container cp=getContentPane();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                             //�����ڻ�����������
		
    cp.add(cardPanel, BorderLayout.CENTER);                                     // �� ��Ƭ���cardPanel ���뵽������������ �м�
        String[] labelNames = { "��ƬA", "��ƬB", "��ƬC" };                        // �����˱�ǩ���� String ����
            for (int i = 0; i < labelNames.length; i++) {                          //ѭ����������ǩ
		JLabel label = new JLabel(labelNames[i]);                          //{
                    label.setHorizontalAlignment(SwingConstants.CENTER);                // ���ñ�ǩ���־���
		    label.setFont(new Font("", Font.BOLD, 16));                         // ���ñ�ǩ�ı�������
	            label.setForeground(new Color(255, 0, 0));                          // ���ñ�ǩ�ı�����ɫ
	            cardPanel.add(label, labelNames[i]);                                // ��Ƭ������ ��ǩ
		}                                                                  //}
		
            
     JPanel buttonPanel=new JPanel();                                           // ����һ����ť��� buttonPanel
	cp.add(buttonPanel, BorderLayout.SOUTH);                                    // ��ӵ������·�
	String[] buttonNames = { "��һ��", "ǰһ��", "��ƬA", "��ƬB", "��ƬC", "��һ��", "���һ��" };
	for (int i = 0; i < buttonNames.length; i++) {
            JButton button = new JButton(buttonNames[i]);
	    button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
                    String buttonText = button.getText();
                    if (buttonText=="��һ��")       cardLayout.first(cardPanel); 
               else if (buttonText=="ǰһ��")       cardLayout.previous(cardPanel); 
	       else if (buttonText=="��ƬA")        cardLayout.show(cardPanel, "��ƬA");
	       else if (buttonText=="��ƬB")        cardLayout.show(cardPanel, "��ƬB"); 
	       else if (buttonText=="��ƬC")        cardLayout.show(cardPanel, "��ƬC"); 
	       else if (buttonText=="��һ��")       cardLayout.next(cardPanel);  
               else if (buttonText=="���һ��")     cardLayout.last(cardPanel); 
		    }
			});
           buttonPanel.add(button);
		}
	}
}

//��һ����õ�Ƭ�� һ��ֻ����ʾһ����