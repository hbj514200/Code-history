import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

public class main extends JFrame {

    public static void main(String args[]) {
        new main().setVisible(true);
    }
	
    public main() {
        setTitle("ѡ����Ƭ�Ի���");
        setBounds(100, 100, 500, 375);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JLabel label = new JLabel("<˫��ѡ����Ƭ>", SwingConstants.CENTER);  
        getContentPane().add(label, BorderLayout.CENTER);
        
        label.addMouseListener(new MouseAdapter() {                             //Ϊ label ��ǩ���һ������¼�
			
            public void mouseClicked(MouseEvent e) {                                //�̶���Ӧ��������
                JFileChooser fileChooser=new JFileChooser();                	     //������һ���ļ�ѡ����	
		javax.swing.filechooser.FileFilter filter = new FileNameExtensionFilter("ͼ���ļ���JPG/GIF��", "JPG", "JPEG", "GIF");     // �����ļ���������ֻ�г�JPG��GIF��ʽ��ͼƬ
		fileChooser.setFileFilter(filter);                                   //�����ļ�ѡ������ setFileFilter �������������ļ�ѡ����˹���      
		if (e.getClickCount()==2) {                                             //������궯���¼��� getClickCount �������Ի�ȡ���������
                    int i = fileChooser.showOpenDialog(getContentPane());                     // ��ʾ�ļ�ѡ��Ի��򣬲���¼���ؽ��
		    if (i == JFileChooser.APPROVE_OPTION) {                                   //��ʾ�� JFileChooser �Ѿ��кϷ���ѡ��
			File selectedFile = fileChooser.getSelectedFile();                    //���ļ�ѡ�������ص��ļ�����н�����
			label.setIcon(new ImageIcon(selectedFile.getAbsolutePath()));         // ��ͼƬ��ʾ����ǩ��
			label.setText(null);     
					}
				}
			}
		});
	}
}

//ԭ��������ּ���JLabel���ֱ�ǩ���������þ�����ʾ��SwingConstants.CENTER.
//�����ļ���������������䵱��ģ��ͺ���
//��һ�����������ڲ����У����Ƿ����Ĳ��֣�����ֱ��{}������䣡��