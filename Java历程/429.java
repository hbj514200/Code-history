import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class main extends JFrame {
 JProgressBar progressBar=new JProgressBar();
 JButton button=new JButton("���");

    public static void main(String[] args) {
        new main().setVisible(true);
    }
 
public main(){
    setSize(240, 150);
    setTitle("������ģ����������");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    Container cp=getContentPane();                                              // �����ڽ�������
    cp.setLayout(new FlowLayout());
    
    cp.add(progressBar);                                                         // ������
        progressBar.setStringPainted(true);
        new Progress(progressBar, button).start();
    
    cp.add(button);                                                              // ��ť
        button.setEnabled(false);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
    });
}
    
public class Progress extends Thread {                                          //���̵߳Ľ�����
  JProgressBar progressBar;                                                         //����һ�� ������
  JButton button;                                                                   //����һ�� ��ť
  
    public Progress(JProgressBar progressBar, JButton button){                   //���췽������������
        this.button=button;         this.progressBar=progressBar;
    }
    
    public void run(){
        for(int i=0; i<100; i++){
            try {
                Progress.sleep(60);
                progressBar.setValue(i);
            } catch (Exception e) {         System.out.println("run()��������");
            }
        }
            progressBar.setIndeterminate(false);
            progressBar.setString("������ɣ�");
            button.setEnabled(true);
    }
    
}
    
}

//�������  �ڲ����ʹ�û���Խ��Խ�㷺�ˡ���
//ԭ������һ���µ� ������ ֻҪû��new��  ��ôʹ�ø���= �Ļ���ֻ��һ��ң������ �൱�� ָ��