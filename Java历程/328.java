import java.awt.*;                                                              //�����       
import javax.swing.*;                                                           //���������
class main extends JFrame {                                                     //���࣬�̳�JFrame
private Thread threadA, threadB;                                                //�����������̴߳��յ�ʵ��
final JProgressBar jindu1=new JProgressBar(), jindu2=new JProgressBar();        //������������������������JProgressBar
int count=0;                                                                    //��������count

public static void main(String[] args)      {   init(new main(), 200, 200);    }//��main������ ����intit�Ĵ��ڶ��󣬴��ڵĴ�С

public main() {                                                                 //����������
getContentPane().add(jindu1, BorderLayout.NORTH);                               //��һ�Ž��������ڴ����ϱ�
getContentPane().add(jindu2, BorderLayout.SOUTH);                               //�Ѷ��Ž��������ڴ����±�
jindu1.setStringPainted(true);      jindu2.setStringPainted(true);              //����������������ʾ����
threadA=new Thread(new Runnable() {                                             //Ϊ�߳�A����Runnble�������ڲ���
       public void run(){                                                       //ʵ���߳̽ӿڵ�run()����
           int count=0;                                                         //��������count����
           while(true){                                                         //ѭ��
               jindu1.setValue(++count);                                        //ͨ�������������setValue�����趨����ֵ
               try {    Thread.sleep(100);   threadB.join();    } catch (Exception e) {  e.printStackTrace();   }   //�̲߳����з���try�� �����߳�B�� ����ThreadB��join������
       }
    }
});
threadA.start();                                                                //ʵ�ֽӿڵ�start(������������û�в�����
threadB=new Thread(new Runnable() {                                             //Ϊ�߳�B����Runnble�������ڲ���
    public void run(){                                                          //ʵ���߳̽ӿڵ�run()����
        int count=0;                                                            //��������count����
        while(true){                                                            //ѭ��
            jindu2.setValue(++count);                                           //ͨ�������������setValue�����趨����ֵ
            try {   Thread.sleep(100);   } catch (Exception e) {     e.printStackTrace();   }   //����sleepʱ������˽��������ٶ�
            if(count==100)       break;                                         //�����������������ѭ������run()������ �����������߳�A��ת�����ģ���������߳�B���н�������Զ������߳�A����ִ��
        }
    }
});
//threadB.start();                                                                //ʵ�ֽӿڵ�start(������������û�в�����
}
    
public static void init(JFrame frame, int width, int height) {
frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
frame.setSize(width,height);
frame.setVisible(true);
}

}

//��ʵ����join����ʵ�ֵĽ��������Ե�