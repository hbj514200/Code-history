import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class main extends JFrame {

    public static void main(String[] args) {
        new main().setVisible(true);
    }
 
public main(){
    Container cp=getContentPane();
    cp.setLayout(new FlowLayout());
    setSize(320, 240);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("�ļ�ѡ�񴰿�");
    
    JButton button=new JButton("ѡ���ļ�");
    cp.add(button);
    
    TextField wenzi=new TextField(30);
    cp.add(wenzi);
    
    
    button.addActionListener(new ActionListener() {                             //Ϊ ��ť ��Ӷ����¼�
        public void actionPerformed(ActionEvent e) {                              //�̶���Ӧ��������
            JFileChooser fileChooser=new JFileChooser();                                //����һ���ļ�ѡ����� FileChooser ��
            int i=fileChooser.showOpenDialog(getContentPane());                         //��ʾ �ļ�ѡ�񴰿�
            if(i==JFileChooser.APPROVE_OPTION){                                         //�ж��û��������ǲ��� ���򿪡� ��ť
                File selectedFile=fileChooser.getSelectedFile();                        //���� File ���� ��  �ļ�ѡ������getSelectedFile���� ���ر�ѡ����ļ�
                wenzi.setText(selectedFile.getName());                                  //�����ļ��� getName()���� ��ȡ�ļ����� ����ʾ��wenzi�ı����С�
            }
        }
    });
}
    
}

//ѡ���ļ�����Ҫio����֧��
// FileChooser ���ļ�ѡ����
//�� int i=fileChooser.showOpenDialog(getContentPane()); ��һ���̶���䣬��ʾһ���ļ�ѡ���  i���ʾ�û�ѡ���״̬�� ����i=1�� ��ʾ�û������ ȷ�� ��ťѡ�����ļ�