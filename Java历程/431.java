import java.io.*;
import java.awt.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.*;

public class main extends JFrame {
    

	public static void main(String args[]) {
		new main().setVisible(true);
	}
	
	public main() {
		setTitle("ʹ�����漯�ɿؼ� ����");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		final JButton dickButton = new JButton();
		dickButton.addActionListener(new ButtonListener(1));
		dickButton.setText("�򿪱�̴ʵ���");
		panel.add(dickButton);
		
		final JButton noteButton = new JButton();
		noteButton.addActionListener(new ButtonListener(2));
                noteButton.setText("�򿪼��±�");
		panel.add(noteButton);
		
		final JButton wordButton = new JButton();
		wordButton.addActionListener(new ButtonListener(0));
		wordButton.setText("��Word");
		panel.add(wordButton);
		
	}
	
	private class ButtonListener implements ActionListener {
		
		int index;
		
		public ButtonListener(int index) {    this.index = index;   }
		
		public void actionPerformed(ActionEvent e) {
			try {
                              if (Desktop.isDesktopSupported()) {                 // �ж�ϵͳ�Ƿ��ṩ�˶Ը����֧��
                              Desktop desktop = Desktop.getDesktop();             // ��ø���Ķ���
	switch (index) {
		case 1:    if (desktop.isSupported(Desktop.Action.BROWSE))            // �ж��Ƿ�֧�֡����������
                                desktop.browse(new URI("http://www.mrbccd.com"));   // �����վ
                                    break;
		case 2:
			   if (desktop.isSupported(Desktop.Action.EDIT))
				desktop.edit(new File("src/new.txt"));                  // �༭���±�
			            break;
		default:   if (desktop.isSupported(Desktop.Action.OPEN))
				desktop.open(new File("src/new.doc"));             // ��Word
	}
}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
}

//���漯������ Desktop �� ������е�isSupported(����) �������Է��ص�ǰϵͳ�Ƿ�֧��ĳЩ���ܣ�     ����desktop.open��new file�ļ�����  Edit BROWSE�ȵȡ���

//����һ����   �������ť����ͬһ����Ӧ�¼�ʱ�� ���Դ���һ������index��  �¼�����Ϳ��Ը���index��ֵ�ж�������Դ��  ��������ͬ�ķ�Ӧ��    �˾ٴ���ǳ���������