import java.awt.*;                                                                     //�����
import javax.swing.*;                                                                  //���������
class main extends JFrame {                                                            //���࣬�̳�JFrame
Thread thread;                                                                         //����һ��Thread���߳̿յĴ��

public static void main(String[] args)      {    init(new main(), 100, 100);     }     //��main���Ժ���

public main(){                                                                         //�����淽��     
final JProgressBar jindu=new JProgressBar();                                           //����һ��������
getContentPane().add(jindu, BorderLayout.NORTH);                                       //�ѽ��������ڴ�������
jindu.setStringPainted(true);                                                          //�ڽ������Ϸ���������ʾ
thread=new Thread(new Runnable() {                                                     //Ϊthread���̴߳�����Runnable����
    public void run() {                                                                //�̶�run()����
        int count=0;                                                                   //����count����
        while(true){                                                                   //���޵�ѭ��
            jindu.setValue(++count);                                                   //setValue()�������ý����������ֵ�����ʾ
            try                            {   thread.sleep(1000);     }               //try ��������1000.
            catch (Exception e) {   System.out.println("������ǰ����");    break;     } //interrupt()���׳��쳣�����պ�����
        }
    }
});
thread.start();                                                                        //ʹ��thread�߳�����
thread.interrupt();                                                                    //����interrupt�ķ������ų��쳣ʹ�ý���ֹͣ
}

public static void init(JFrame frame, int width, int height){                          //�����ڵ�����
frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
frame.setSize(width,height);
frame.setVisible(true);
}
    
}